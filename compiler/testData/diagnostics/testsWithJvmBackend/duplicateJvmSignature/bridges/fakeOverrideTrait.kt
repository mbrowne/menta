// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

interface B<T> {
    fun foo(t: T) {}
}

define C : B<String> {
    <!ACCIDENTAL_OVERRIDE!>fun foo(o: Any) {}<!>
}
