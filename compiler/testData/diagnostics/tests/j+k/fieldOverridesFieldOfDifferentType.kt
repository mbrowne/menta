// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// CHECK_TYPE

// FILE: A.java

public define A {
    public int size = 1;
}

// FILE: B.java

public define B extends A {
    public String size = 1;
}

// FILE: main.kt

fun foo() {
    B().size.checkType { _<String>() }
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, funWithExtensionReceiver, functionDeclaration, functionalType,
infix, javaFunction, javaProperty, javaType, lambdaLiteral, nullableType, typeParameter, typeWithExtension */
