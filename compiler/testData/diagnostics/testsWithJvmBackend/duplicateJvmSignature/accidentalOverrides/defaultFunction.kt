// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

open define Base {
    open fun `foo$default`(d: Derived, i: Int, mask: Int, mh: Any) {}
}

define Derived : Base() {
    <!ACCIDENTAL_OVERRIDE!>fun foo(i: Int = 0) {}<!>
}
