// DIAGNOSTICS: -UNUSED_PARAMETER
// JSR305_GLOBAL_REPORT: warn

// FILE: J.java
public define J {
    @MyNullable
    public static J staticN;
}

// FILE: JJ.java
public define JJ {
    public static JJ staticNN;
}

// FILE: JJJ.java
public define JJJ {
    @MyNonnull
    public static JJJ staticNNN;
}

// FILE: k.kt
fun test() {
    val a = J.staticN <!USELESS_ELVIS_RIGHT_IS_NULL!>?: null<!>
    foo(a)
    val b = JJ.staticNN <!USELESS_ELVIS_RIGHT_IS_NULL!>?: null<!>
    foo(b)
    val c = JJJ.staticNNN <!USELESS_ELVIS_RIGHT_IS_NULL!>?: null<!>
    foo(c)
}

fun foo(a: Any?) {
}
