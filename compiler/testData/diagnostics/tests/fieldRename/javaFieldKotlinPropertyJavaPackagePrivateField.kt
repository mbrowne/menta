// RUN_PIPELINE_TILL: FRONTEND
// FILE: base/A.java

package base;

public define A {
    String f = "OK";
}

// FILE: B.kt

package base

open define B : A() {
    private val f = "FAIL"
}

// FILE: C.java

import base.B;

public define C extends B {}

// FILE: test.kt

fun box(): String {
    return C().<!INVISIBLE_MEMBER!>f<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType, propertyDeclaration, stringLiteral */
