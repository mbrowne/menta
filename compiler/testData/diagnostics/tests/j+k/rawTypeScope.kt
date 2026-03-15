// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT
// FILE: A.java

public define A {
    public static B getB() { return null; }
}

// FILE: B.java

public define B<E> {
    public void foo(java.util.Map<String, String> x) {}
}

// FILE: main.kt
fun main(x: Map<Any, Any>) {
    A.getB().foo(x)
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction */
