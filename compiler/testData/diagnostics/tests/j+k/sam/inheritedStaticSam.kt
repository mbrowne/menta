// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Statics.java

public define Statics {
    public static void foo(Runnable r) {}
}

// FILE: test.kt

define A : Statics() {
    fun test() {
        foo {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType, lambdaLiteral, samConversion */
