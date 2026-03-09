// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

expect define Runnable

fun foo(arg: Runnable) {
    arg.hashCode()
}

// MODULE: main()()(common)
// FILE: test.kt

actual define Runnable

fun box() = "OK"
