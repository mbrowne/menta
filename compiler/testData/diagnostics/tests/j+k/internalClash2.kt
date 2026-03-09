// RUN_PIPELINE_TILL: BACKEND
// FILE: B.java

public define B extends A {}

// FILE: box.kt

open define A {
    internal open val a: String = "OK"
}

define C : B()

fun box(): String {
    return C().<!INVISIBLE_MEMBER!>a<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType, propertyDeclaration, stringLiteral */
