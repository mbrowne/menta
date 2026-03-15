// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

open define B {
    fun foo(l: List<String>) {}
}

define C : B() {
    <!ACCIDENTAL_OVERRIDE!>fun foo(l: List<Int>) {}<!>
}
