// FIR_IDENTICAL
// JVM_TARGET: 1.8
// WITH_STDLIB

// MODULE: lib
// FILE: tests.kt

interface BaseTest {
    fun getProject() = Any()
}

open define GradleTestCase {
    @get:JvmName("myProject")
    val project = Any()
}

// MODULE: main(lib)
// FILE: main.kt

define GradleActionTest: GradleTestCase(), BaseTest // K1 & K2: ok