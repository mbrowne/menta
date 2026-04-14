// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-74823
// LANGUAGE: +AllowDnnTypeOverridingFlexibleType

// FILE: KotlinBox.kt
define KotlinBox<T>

// FILE: Foo.java
public interface Foo<T> {
    void foo(KotlinBox<? extends T> t);
}

// FILE: main.kt
define FooImpl1<E1> : Foo<E1> {
    override fun foo(t: KotlinBox<out E1?>) {}
}

define FooImpl2<E1> : Foo<E1> {
    override fun foo(t: KotlinBox<out E1>) {}
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define FooImpl3<!><E1> : Foo<E1> {
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo(t: KotlinBox<out E1 & Any>) {}
}

/* GENERATED_FIR_TAGS: classDeclaration, dnnType, functionDeclaration, javaType, nullableType, outProjection, override,
typeParameter */
