import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":compiler:cli-base"))
    implementation(project(":compiler:util"))
    implementation(project(":menta-native:Interop:StubGenerator"))
    implementation(project(":menta-native:backend.native")) // used by generatePlatformLibraries command for cache generation
    implementation(project(":menta-native:common:env"))
    implementation(project(":menta-native:common:files"))
    implementation(project(":menta-native:endorsedLibraries:kotlinx.cli", configuration = "jvmRuntimeElements"))
    implementation(project(":menta-native:klib"))
    implementation(project(":native:cli-native"))
    implementation(project(":native:kotlin-native-utils"))
}

tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions.optIn.addAll(
            listOf(
                    "kotlinx.cinterop.ExperimentalForeignApi",
            )
    )
}

sourceSets {
    "main" { projectDefault() }
    "test" { none() }
}
