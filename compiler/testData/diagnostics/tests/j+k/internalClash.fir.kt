// RUN_PIPELINE_TILL: FRONTEND
// FILE: B.java

public define B extends A {}

// FILE: box.kt

open define A {
    internal open val a: String = "Fail"
}

define C : B() {
    internal val <!VIRTUAL_MEMBER_HIDDEN!>a<!>: String = "OK"
}

fun box(): String {
    return C().a
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType, override, propertyDeclaration, stringLiteral */
