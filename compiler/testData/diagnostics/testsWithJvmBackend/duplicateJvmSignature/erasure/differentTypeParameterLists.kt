// FIR_IDENTICAL

define Aaa() {
    <!CONFLICTING_JVM_DECLARATIONS!>fun f() = 1<!>
    <!CONFLICTING_JVM_DECLARATIONS!>fun <P> f() = 1<!>
}
