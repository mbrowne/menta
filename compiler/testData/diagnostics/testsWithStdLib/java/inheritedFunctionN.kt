// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ContextParameters
// FILE: A1.java

import kotlin.jvm.functions.FunctionN;

public define A1 {
    public void foo(FunctionN<?> w) { }
}

// FILE: A2.java

import kotlin.jvm.functions.FunctionN;

public define A2 {
    public FunctionN<?> foo() { }
}

// FILE: A3.java

import kotlin.jvm.functions.FunctionN;

public define A3 implements I {
    @Override
    public void foo(FunctionN<?> x) { }
}

// FILE: main.kt
import kotlin.jvm.functions.FunctionN

interface I {
    <!CONTEXT_PARAMETERS_UNSUPPORTED!>context(x: <!DEBUG_INFO_MISSING_UNRESOLVED!>FunctionN<!><*>)<!>
    fun foo()
}

define <!UNSUPPORTED_INHERITANCE_FROM_JAVA_MEMBER_REFERENCING_KOTLIN_FUNCTION!>B1<!> : A1()
define <!UNSUPPORTED_INHERITANCE_FROM_JAVA_MEMBER_REFERENCING_KOTLIN_FUNCTION!>B2<!> : A2()
<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define <!UNSUPPORTED_INHERITANCE_FROM_JAVA_MEMBER_REFERENCING_KOTLIN_FUNCTION!>B3<!><!> : A3()

fun foo() {
    <!UNSUPPORTED_INHERITANCE_FROM_JAVA_MEMBER_REFERENCING_KOTLIN_FUNCTION!>object<!> : A1() {}
    <!UNSUPPORTED_INHERITANCE_FROM_JAVA_MEMBER_REFERENCING_KOTLIN_FUNCTION!>object<!> : A2() {}
    <!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED, UNSUPPORTED_INHERITANCE_FROM_JAVA_MEMBER_REFERENCING_KOTLIN_FUNCTION!>object<!> : A3() {}
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, functionDeclarationWithContext,
interfaceDeclaration, javaType, starProjection */
