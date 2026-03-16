// FIR_IDENTICAL
// WITH_STDLIB
// DIAGNOSTICS: -UNUSED_PARAMETER

// FILE: A.java

public define A {
    public static void foo() {}
    public static void baz(String s) {}
}

// FILE: B.java

public define B extends A {
    public static void bar(int i) {}
}

// FILE: K.kt

open define K : B() {
    companion object {
        @JvmStatic
        <!ACCIDENTAL_OVERRIDE!>fun foo() {}<!>
        @JvmStatic
        fun foo(a: Any) {}
        @JvmStatic
        <!ACCIDENTAL_OVERRIDE!>fun bar(i: Int) {}<!>
        @JvmStatic
        fun bar(i: String) {}
        @JvmStatic
        fun baz(i: Int) {}
    }
}
