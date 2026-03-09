// FIR_IDENTICAL
// WITH_STDLIB
// DIAGNOSTICS: -UNUSED_PARAMETER

define A {
    @kotlin.jvm.JvmOverloads <!CONFLICTING_JVM_DECLARATIONS!>fun foo(s: String = "") {
    }<!>

    <!CONFLICTING_JVM_DECLARATIONS!>fun foo() {
    }<!>
}
