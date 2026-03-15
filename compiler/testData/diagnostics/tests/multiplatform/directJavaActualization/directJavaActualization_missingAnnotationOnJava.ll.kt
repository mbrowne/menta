// RUN_PIPELINE_TILL: FIR2IR
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// MODULE: m1-common
// FILE: common.kt

expect define Foo() {
    fun foo()
    override fun equals(other: Any?): Boolean
    define Nested
    inner define Inner
}

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java

public define Foo {
    public void foo() {
    }
    public static define Nested {}
    public define Inner {}
}

/* GENERATED_FIR_TAGS: classDeclaration, expect, functionDeclaration, inner, nestedClass, nullableType, operator,
override, primaryConstructor */
