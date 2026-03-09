// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

open define B<T> {
    open fun foo(t: T) {}
}

define C : B<String>() {
    override fun foo(t: String) {}

    <!ACCIDENTAL_OVERRIDE!>fun foo(o: Any) {}<!>
}
