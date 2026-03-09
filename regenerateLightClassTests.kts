import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Script to regenerate light class test snapshot files
 * Usage: kotlinc -cp <classpath> -script regenerateLightClassTests.kts
 */

println("Light Class Test Data Regeneration Script")
println("==========================================")
println()

val testDataDir = File("compiler/testData/asJava/lightClasses/lightClassByFqName")

if (!testDataDir.exists()) {
    println("ERROR: Test data directory not found: ${testDataDir.absolutePath}")
    System.exit(1)
}

val ktFiles = testDataDir.listFiles { f -> 
    f.isFile && f.name.endsWith(".kt")
}?.sortedBy { it.name } ?: emptyList()

println("Found ${ktFiles.size} Kotlin test files")
println()

// List of test files that failed
val failedTests = setOf(
    "AnnotatedParameterInEnumConstructor",
    "AnnotatedParameterInInnerClassConstructor",
    // Add all 148 failed test names here...
)

println("This script needs to be run with the Kotlin compiler on the classpath.")
println()
println("Since the Gradle test update mechanism doesn't automatically regenerate these files,")
println("we need an alternative approach:")
println()
println("= RECOMMENDED SOLUTION =")
println()
println("1. Open the project in IntelliJ IDEA")
println("2. Navigate to: compiler/tests/org/jetbrains/kotlin/asJava/AbstractCompilerLightClassTest.kt")
println("3. Run one of the failing tests (e.g., CompilerLightClassTestGenerated.testAnnotatedParameterInEnumConstructor)")
println("4. IntelliJ will show a diff popup with 'Accept all' option")
println("5. Click 'Accept all' to update all the snapshot files at once")
println()
println("= ALTERNATIVE: MANUAL UPDATE =")
println()
println("If you don't have IDE access, the test data files that need updating are:")

for (ktFile in ktFiles) {
    val baseName = ktFile.nameWithoutExtension
    val descriptorsFile = File(testDataDir, "$baseName.descriptors.java")
    
    if (descriptorsFile.exists()) {
        println("  - $baseName")
    }
}
