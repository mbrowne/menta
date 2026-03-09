// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt
expect define A {
    define B {
        fun foo()
    }
}

// MODULE: main()()(common)
// FILE: test.kt
actual define A {
    actual define B {
        actual fun foo() {}
    }
}

fun box() = "OK" // check no errors are thrown during building FIR member mapping
