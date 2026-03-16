// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// FILE: A.java

public define A {
    public static int a = 1;
    public static void foo() {}
    public static void baz(String s) {}
}

// FILE: K.kt

open define K : A() {
    val a = 1
    <!ACCIDENTAL_OVERRIDE!>fun foo() {}<!>
    fun foo(i: Int) {}
    fun baz(i: Int) {}

    companion object {
        fun foo() {}
    }
}
