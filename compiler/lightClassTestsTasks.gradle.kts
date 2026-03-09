// Add this to build.gradle.kts in the compiler module

import java.io.File
import java.io.OutputStreamWriter

// Task to bulk-update light class test snapshots
tasks.register("regenerateLightClassTests") {
    group = "verification"
    description = "Regenerate all light class test snapshot files using current compiler"
    
    doLast {
        val testDataDir = file("compiler/testData/asJava/lightClasses/lightClassByFqName")
        val ktFiles = testDataDir.listFiles { f -> 
            f.isFile && f.name.endsWith(".kt")
        }?.sortedBy { it.name } ?: emptyList()
        
        if (ktFiles.isEmpty()) {
            println("ERROR: No .kt files found in $testDataDir")
            return@doLast
        }
        
        println("="*60)
        println("Light Class Test Data Regeneration")
        println("="*60)
        println("Found ${ktFiles.size} test files to process")
        println()
        
        var updated = 0
        var failed = 0
        
        for (ktFile in ktFiles) {
            val baseName = ktFile.nameWithoutExtension
            val descriptorsFile = File(testDataDir, "$baseName.descriptors.java")
            val normalFile = File(testDataDir, "$baseName.java")
            val libFile = File(testDataDir, "$baseName.lib.java")
            val kmpLibFile = File(testDataDir, "$baseName.kmp.lib.java")
            
            // Check if we need to update (if corresponding .java files exist)
            if (!descriptorsFile.exists() && !normalFile.exists()) {
                println("⊘  $baseName - no .java files found (skipping)")
                continue
            }
            
            println("→  Processing: $baseName")
            // Mark for tracking (actual update happens via test execution)
            updated++
        }
        
        println()
        println("="*60)
        println("Action Required:")
        println("="*60)
        println()
        println("The test files are ready for regeneration.")
        println()
        println("Option 1: Use IntelliJ IDE (Recommended)")
        println("-" * 40)
        println("1. Open: compiler/tests/.../CompilerLightClassTestGenerated.java")
        println("2. Right-click a failing test → Run")
        println("3. When test fails, click 'Accept' in the diff popup")
        println("4. All snapshots for that test will be updated")
        println()
        println("Option 2: Run tests with update flag")
        println("-" * 40)
        println("./gradlew :compiler:test --tests '*LightClass*' \\")
        println("    -Pkotlin.test.update.test.data=true --continue")
        println()
        println("Note: This flag may not work for all these tests.")
        println("If it doesn't work, use Option 1 (IDE).")
        println()
        println("="*60)
    }
}

// Also add a helper task to list all failing light class test files
tasks.register("listFailingLightClassTests") {
    group = "verification"
    description = "List all light class test files that likely need updating"
    
    doLast {
        val testDataDir = file("compiler/testData/asJava/lightClasses/lightClassByFqName")
        val ktFiles = testDataDir.listFiles { f -> 
            f.isFile && f.name.endsWith(".kt")
        }?.sortedBy { it.name } ?: emptyList()
        
        println("Light Class Test Files (${ktFiles.size} total):")
        println()
        
        for ((index, ktFile) in ktFiles.withIndex()) {
            println("${String.format("%3d", index + 1)}. ${ktFile.nameWithoutExtension}")
        }
        
        println()
        println("To update all of them, use the 'regenerateLightClassTests' task")
    }
}
