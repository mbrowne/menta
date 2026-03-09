// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

// FILE: A.java

public define A<T> {
    public void add(T x) {}
    public static define B extends A<Runnable> {}
}

// FILE: test.kt

fun test(x: A.B) {
    x.add { }
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaType, lambdaLiteral, samConversion */
