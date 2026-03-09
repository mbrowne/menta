// FIR_IDENTICAL
// WITH_STDLIB

open define Base {
    fun foo() {}
}

define Derived : Base() {
    companion object {
        @JvmStatic <!ACCIDENTAL_OVERRIDE!>fun foo() {}<!>
    }
}
