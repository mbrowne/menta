# Light Class Bulk Regeneration Tool - Implementation Guide

## Problem
The 148 failing light class tests need snapshot file regeneration. The test framework's `-Pkotlin.test.update.test.data=true` flag doesn't work for `AbstractCompilerLightClassTest` because:
- Auto-creation in `TestDataAssertions.tryLoadExpectedFile()` only happens when files are MISSING
- These tests have files that EXIST but DIFFER from current compiler output
- Running tests with existing mismatched files just throws AssertionFailedError

## Solution: Direct API Call Pattern

You need a Kotlin/Java tool that **directly calls the light class generation API** and writes files. Here's the exact pattern:

---

## Core API Pattern

### 1. The Key Method
```kotlin
package org.jetbrains.kotlin.asJava

fun getActualLightClassText(
    testDataFile: File,                                    // Source .kt file
    findLightClass: (String) -> PsiClass?,                // Lambda to find light class
    normalizeText: (String) -> String,                     // Text post-processor
    membersFilter: PsiClassRenderer.MembersFilter = DEFAULT // Rendering options
): String
```

### 2. The Workflow

The test infrastructure does this (from `AbstractCompilerLightClassTest`):

```kotlin
override fun doMultiFileTest(wholeFile: File, files: List<TestFile>) {
    // Step 1: Create compilation environment
    val environment = createEnvironment(wholeFile, files)
    
    // Step 2: Determine output file variant
    val expectedFile = KotlinTestUtils.replaceExtension(wholeFile, "descriptors.java").takeIf(File::exists)
        ?: KotlinTestUtils.replaceExtension(wholeFile, "java")
    
    // Step 3: Generate actual light class text
    val actual = LightClassTestCommon.getActualLightClassText(
        wholeFile,
        { fqname -> findLightClass(allowFrontendExceptions, environment, fqname) },
        { LightClassTestCommon.removeEmptyDefaultImpls(it)
            .replace("\$test_module", "\$light_idea_test_case") },
    )
    
    // Step 4: Normalize (in your bulk tool, just write directly)
    // TestDataAssertions.assertEqualsToFile(expectedFile, actual)
    
    // For bulk regeneration, you would instead:
    expectedFile.writeText(actual)  // <-- Direct write
}
```

### 3. Finding the Light Class

From `AbstractCompilerLightClassTest.findLightClass()`:

```kotlin
companion object {
    fun findLightClass(
        allowFrontendExceptions: Boolean, 
        environment: KotlinCoreEnvironment, 
        fqname: String
    ): PsiClass? {
        // Step 1: Resolve all Kotlin files to build analysis data
        try {
            KotlinTestUtils.resolveAllKotlinFiles(environment)
        } catch (e: KotlinFrontEndException) {
            if (!allowFrontendExceptions) throw e
        }

        // Step 2: Search for light class in analysis
        val searchScope = GlobalSearchScope.allScope(environment.project)
        val kotlinAsJavaSupport = KotlinAsJavaSupport.getInstance(environment.project)
        
        // Try script classes first
        val lightClassForScript = kotlinAsJavaSupport
            .getScriptClasses(FqName(fqname), searchScope)
            .firstOrNull()

        // Then try finding as regular class
        return lightClassForScript
            ?: JavaElementFinder.getInstance(environment.project)
                .findClass(fqname, searchScope)
            ?: kotlinAsJavaSupport.findClassOrObjectDeclarations(FqName(fqname), searchScope)
                .firstOrNull { it is KtEnumEntry }
                ?.toLightClass()
    }
}
```

---

## Standalone Tool Structure

Here's the complete standalone tool you should create:

```kotlin
// regenerator/src/main/kotlin/LightClassBulkRegenerator.kt

import com.intellij.openapi.util.io.FileUtil
import com.intellij.psi.PsiClass
import com.intellij.psi.search.GlobalSearchScope
import org.jetbrains.kotlin.asJava.LightClassTestCommon
import org.jetbrains.kotlin.asJava.KotlinAsJavaSupport
import org.jetbrains.kotlin.asJava.finder.JavaElementFinder
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.jetbrains.kotlin.config.CommonConfigurationKeys
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.JVMConfigurationKeys
import org.jetbrains.kotlin.config.LanguageVersionSettingsImpl
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtEnumEntry
import org.jetbrains.kotlin.test.KotlinTestUtils
import org.jetbrains.kotlin.test.util.KtTestUtil
import org.jetbrains.kotlin.util.KotlinFrontEndException
import java.io.File

object LightClassBulkRegenerator {
    private val TEST_DATA_DIR = File("compiler/testData/asJava/lightClasses/lightClassByFqName")
    
    // Extension priority for output files (tries in order)
    private val OUTPUT_EXTENSIONS = listOf(".descriptors.java", ".java", ".lib.java", ".kmp.lib.java")

    fun main() {
        println("Light Class Test Snapshot Regenerator")
        println("=" * 50)
        println()

        val ktFiles = TEST_DATA_DIR.listFiles { f -> 
            f.isFile && f.name.endsWith(".kt") && !f.name.contains("local") && !f.name.contains("ideRegression")
        }?.sortedBy { it.name } ?: emptyList()

        println("Found ${ktFiles.size} Kotlin source files")
        println()

        var successCount = 0
        var failureCount = 0
        val failures = mutableListOf<Pair<String, String>>() // (file, error)

        for ((index, ktFile) in ktFiles.withIndex()) {
            val progress = "${index + 1}/${ktFiles.size}"
            print("[$progress] Processing ${ktFile.name}... ")

            try {
                regenerateTestFile(ktFile)
                println("OK")
                successCount++
            } catch (e: Exception) {
                println("FAILED: ${e.message}")
                failures.add(ktFile.name to (e.message ?: e.toString()))
                failureCount++
            }
        }

        println()
        println("=" * 50)
        println("Results:")
        println("  Success: $successCount")
        println("  Failed:  $failureCount")
        
        if (failures.isNotEmpty()) {
            println()
            println("Failed files:")
            for ((file, error) in failures) {
                println("  - $file: $error")
            }
        } else {
            println()
            println("All files regenerated successfully!")
        }
    }

    private fun regenerateTestFile(ktFile: File) {
        // Step 1: Determine output file variant
        val baseName = ktFile.nameWithoutExtension
        val outputFile = OUTPUT_EXTENSIONS.mapNotNull { ext ->
            File(TEST_DATA_DIR, "$baseName$ext").takeIf { it.exists() }
        }.firstOrNull() 
            ?: File(TEST_DATA_DIR, "$baseName.java")  // Default fallback

        // Step 2: Create compilation environment
        val environment = createTestEnvironment(ktFile)

        // Step 3: Generate actual light class text
        val actual = try {
            LightClassTestCommon.getActualLightClassText(
                ktFile,
                { fqname -> findLightClass(environment, fqname) },
                { 
                    // Normalize the same way AbstractCompilerLightClassTest does
                    LightClassTestCommon.removeEmptyDefaultImpls(it)
                        .replace("\$test_module", "\$light_idea_test_case")
                }
            )
        } catch (e: Exception) {
            throw RuntimeException(
                "Failed to generate light class text for ${ktFile.name}: ${e.message}", 
                e
            )
        }

        // Step 4: Write to output file
        outputFile.parentFile?.mkdirs()
        outputFile.writeText(actual)
    }

    private fun createTestEnvironment(ktFile: File): KotlinCoreEnvironment {
        val configuration = CompilerConfiguration().apply {
            // Set language version
            put(CommonConfigurationKeys.LANGUAGE_VERSION_SETTINGS, 
                LanguageVersionSettingsImpl.DEFAULT)
            
            // Set JDK
            put(JVMConfigurationKeys.JDK_HOME, File(System.getProperty("java.home")))
            
            // Set classpath (compiler jars, kotlin stdlib)
            // This depends on your environment - may need adjustment
        }

        // Create test environment with the test file
        return KotlinCoreEnvironment.createForProduction(
            { },
            configuration,
            listOf(ktFile)
        )
    }

    private fun findLightClass(
        environment: KotlinCoreEnvironment,
        fqname: String
    ): PsiClass? {
        // Resolve all files in the environment
        try {
            KotlinTestUtils.resolveAllKotlinFiles(environment)
        } catch (e: KotlinFrontEndException) {
            // For some files, frontend exceptions are expected
            // Proceed anyway
        }

        val searchScope = GlobalSearchScope.allScope(environment.project)
        val kotlinAsJavaSupport = KotlinAsJavaSupport.getInstance(environment.project)

        // Try script classes first
        val lightClassForScript = kotlinAsJavaSupport
            .getScriptClasses(FqName(fqname), searchScope)
            .firstOrNull()

        // Then try regular class/object lookup
        return lightClassForScript
            ?: JavaElementFinder.getInstance(environment.project)
                .findClass(fqname, searchScope)
            ?: kotlinAsJavaSupport.findClassOrObjectDeclarations(FqName(fqname), searchScope)
                .firstOrNull { it is KtEnumEntry }
                ?.toLightClass()
    }
}

fun main(args: Array<String>) {
    LightClassBulkRegenerator.main()
}
```

---

## Gradle Task Wrapper

Add this to your `build.gradle.kts` to make it a Gradle task:

```kotlin
tasks.register<JavaExec>("regenerateLightClassTests") {
    description = "Regenerate all light class test snapshot files"
    group = "verification"
    
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("LightClassBulkRegeneratorKt")
    
    // Run from project root
    workingDir = rootProject.projectDir
    
    // Show output
    standardOutput = System.out
    standardError = System.err
    
    doFirst {
        println("Regenerating light class test snapshots...")
    }
}
```

Run with:
```bash
./gradlew regenerateLightClassTests
```

---

## Variant Selection Logic

The tool should prefer files in this order:
1. `.descriptors.java` - Standard descriptor-based output (highest priority)
2. `.java` - Default output
3. `.lib.java` - Library variant
4. `.kmp.lib.java` - Kotlin Multiplatform variant
5. `.compiled.java` - Compiled variant (rarely used)
6. `.kmp.java` - KMP variant

The code above checks for existing files and falls back to `.java` if none exist.

---

## Key Classes Used

| Class | Purpose |
|-------|---------|
| `LightClassTestCommon` | Contains `getActualLightClassText()` and rendering helpers |
| `KotlinCoreEnvironment` | Holds the compilation environment (project, files, config) |
| `JavaElementFinder` | Finds PsiClass by FQ name from compiled code |
| `KotlinAsJavaSupport` | Finds light classes for Kotlin declarations |
| `GlobalSearchScope.allScope()` | Scope for symbol resolution |
| `KotlinTestUtils.resolveAllKotlinFiles()` | Analyzes all files in environment |

---

## Important Notes

1. **FQ Name Extraction**: The first line of each .kt file must be a comment with the FQ name:
   ```kotlin
   // package.name.ClassName
   ```
   This is extracted by `LightClassTestCommon.fqNameInTestDataFile()`

2. **Normalization**: The tool applies the same normalization as the test:
   - Removes empty `DefaultImpls` inner classes
   - Replaces `$test_module` with `$light_idea_test_case`

3. **Sanitization**: The test infrastructure also applies:
   - Line separator normalization (CRLF → LF)
   - Trim trailing whitespace
   - Add newline at EOF
   These happen in `TestDataAssertions.applyDefaultAndCustomSanitizer()`

4. **Class Path**: The `KotlinCoreEnvironment` needs the Kotlin compiler and JDK on classpath - ensure your Gradle task has correct dependencies

---

## Testing the Tool

1. Run it on a subset first:
   ```bash
   # Modified main() that only processes first 5 files
   for file in SourceFiles.take(5) { regenerateTestFile(file) }
   ```

2. Verify output is correct:
   ```bash
   git diff compiler/testData/asJava/lightClasses/lightClassByFqName/ | head -50
   ```

3. Check that changes are consistent across files

4. Run tests to verify:
   ```bash
   ./gradlew :compiler:test --tests CompilerLightClassTestGenerated -q
   ```

