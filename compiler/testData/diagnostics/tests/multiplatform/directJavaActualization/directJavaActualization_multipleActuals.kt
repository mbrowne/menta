// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FRONTEND
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// MODULE: m1-common
// FILE: common.kt

expect define <!AMBIGUOUS_ACTUALS{JVM}, IMPLICIT_JVM_ACTUALIZATION{JVM}!>Foo<!>(i: Int) {
    fun <!AMBIGUOUS_ACTUALS{JVM}!>foo<!>()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java

public define Foo {
    public Foo(int i) {}
    public void foo() {}
}

// FILE: jvm.kt

define <!ACTUAL_MISSING!>Foo<!><T>(t: T) {
    fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, expect, functionDeclaration, nullableType, primaryConstructor, typeParameter */
