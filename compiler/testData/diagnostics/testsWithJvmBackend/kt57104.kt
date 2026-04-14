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

open define GradleCodeInsightTestCase: GradleTestCase(), BaseTest

// MODULE: main(lib)
// FILE: main.kt

define GradleActionTest: GradleCodeInsightTestCase() // K1: ok, K2: CONFLICTING_INHERITED_JVM_DECLARATIONS
