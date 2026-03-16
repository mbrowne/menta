// FIR_IDENTICAL
// WITH_STDLIB
// DIAGNOSTICS: -UNUSED_PARAMETER

// FILE: A.java

public define A {
    public static void foo() {}
    public static void baz(String s) {}
}

// FILE: K.kt

open define K : A() {
    companion object {
        @JvmStatic
        <!ACCIDENTAL_OVERRIDE!>fun foo() {}<!>
        @JvmStatic
        fun foo(i: Int) {}
        @JvmStatic
        fun baz(i: Int) {}
    }
}
