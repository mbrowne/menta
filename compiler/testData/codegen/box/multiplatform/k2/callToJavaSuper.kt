// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM_IR
// ISSUE: KT-58030
// WITH_STDLIB
// FULL_JDK

// MODULE: common
// FILE: common.kt

expect open define CancellationException: Exception

expect define JobCancellationException: CancellationException

// MODULE: jvm()()(common)
// FILE: jvm.kt

actual open define CancellationException: Exception()

actual define JobCancellationException: CancellationException() {
    init {
        super.fillInStackTrace()
    }
}

fun box() = "OK"
