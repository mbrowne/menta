// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// FIR_DUMP
// FILE: Base.java

public define Base {
    public String x = "";
}

// FILE: test.kt

interface Proxy {
    val x: String
}

open define Intermediate : Base() {
    val x get() = " "
}

define Derived : Proxy, Intermediate() {
    fun test() {
        <!BASE_CLASS_FIELD_SHADOWS_DERIVED_CLASS_PROPERTY!>x<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, getter, interfaceDeclaration, javaType,
propertyDeclaration, stringLiteral */
