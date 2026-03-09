// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-72356

// MODULE: common
// FILE: A.kt
annotation define A(val x: String)

annotation define Something

// FILE: B.kt
expect interface B

// FILE: D.kt
define D {               @Something fun bar() {} }

define E : B

// MODULE: platform()()(common)
// FILE: B.kt
actual interface B { @A("12345678") fun foo() {} }

fun box(): String {
    return "OK"
}
