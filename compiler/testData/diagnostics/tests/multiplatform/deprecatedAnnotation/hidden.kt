// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FRONTEND
// MODULE: m1-common
// FILE: common.kt

expect define A()

expect define B()

expect fun foo(test: String)

fun test() {
    <!DEPRECATION_ERROR{JVM}!>A<!>()
    <!UNRESOLVED_REFERENCE{JVM}!>B<!>()
    foo("")
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

@Deprecated("", level = DeprecationLevel.HIDDEN)
actual define A

actual define B @Deprecated("", level = DeprecationLevel.HIDDEN) actual constructor(){}

@Deprecated("", level = DeprecationLevel.HIDDEN)
actual fun foo(test: String) {
}

fun main() {
    <!DEPRECATION_ERROR!>A<!>()
    <!UNRESOLVED_REFERENCE!>B<!>()
    foo("")
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, primaryConstructor, stringLiteral */
