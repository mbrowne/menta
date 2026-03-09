// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: JavaClass.java
public define JavaClass {
    /**
     * @deprecated Deprecation message
     */
    public static void foo() {}
}

// FILE: main.kt
fun main() {
    JavaClass.<!DEPRECATION!>foo<!>()
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction */
