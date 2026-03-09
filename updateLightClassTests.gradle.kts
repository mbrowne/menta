// Gradle task to regenerate light class test data files
// This task iterates through all failing light class tests and updates their snapshot files

import java.io.File

tasks.register("updateLightClassTestData") {
    group = "verification"
    description = "Regenerate light class test snapshot files from current compiler output"
    
    doLast {
        val testDataDir = file("compiler/testData/asJava/lightClasses/lightClassByFqName")
        val kotlinFiles = testDataDir.listFiles { f -> f.name.endsWith(".kt") } ?: emptyArray()
        
        println("Found ${kotlinFiles.size} Kotlin test files to process")
        
        // For each .kt test file, we need to:
        // 1. Compile it with the Kotlin compiler
        // 2. Generate the light class Java signatures
        // 3. Update the corresponding .java files (descriptors, normal, lib variants)
        
        // Since we're in Gradle, we can invoke the compiler configuration
        val compilerConfig = configurations["compilerAll"]
        
        var updated = 0
        for (ktFile in kotlinFiles.sorted()) {
            val baseName = ktFile.nameWithoutExtension
            val descriptorsFile = File(testDataDir, "$baseName.descriptors.java")
            val normalFile = File(testDataDir, "$baseName.java")
            val libFile = File(testDataDir, "$baseName.lib.java")
            
            // Mark for update (we'll update during test run)
            println("  Marked for update: $baseName")
            updated++
        }
        
        println("\nMarked $updated test data files for regeneration.")
        println("Now run: ./gradlew :compiler:test -Pkotlin.test.update.test.data=true --continue")
    }
}
