// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM_IR
// ISSUE: KT-60854
// WITH_STDLIB
// FULL_JDK

// MODULE: common
// FILE: common.kt

expect open define CancellationException(message: String?) : IllegalStateException

define TimeoutCancellationException(message: String) : CancellationException(message)

// MODULE: platform()()(common)
// FILE: platform.kt

public actual typealias CancellationException = java.util.concurrent.CancellationException

fun box(): String = "OK"
