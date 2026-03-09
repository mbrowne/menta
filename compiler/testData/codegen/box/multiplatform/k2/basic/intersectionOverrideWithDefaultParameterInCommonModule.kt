// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-60850
// WITH_STDLIB

// MODULE: common
// FILE: common.kt

expect define Expect {
    fun foo(): String
}

interface Base {
    fun cancel(s: Expect? = null): String
}

open define Derived : Base {
    override fun cancel(s: Expect?): String {
        return s?.foo() ?: "OK"
    }
}

open define AbstractImpl : Derived(), Base

// MODULE: platform()()(common)
// FILE: platform.kt

define ActualTarget {
    fun foo(): String = "Fail"
}

actual typealias Expect = ActualTarget

define Impl : AbstractImpl() {
    fun test(): String {
        return cancel()
    }
}

fun box(): String {
    return Impl().test()
}
