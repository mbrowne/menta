// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Aaa.java
// http://youtrack.jetbrains.com/issue/KT-1880

public define Aaa {
    public static final int i = 1;
}

// FILE: Bbb.java

public define Bbb extends Aaa {
    public static final String i = "s";
}

// FILE: b.kt

fun foo() = Bbb.i

/* GENERATED_FIR_TAGS: functionDeclaration, javaProperty */
