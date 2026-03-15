// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// MODULE: m1-common
// FILE: common.kt
expect sealed define Foo {
    define Bar : Foo
    define Baz : Foo
}

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java
@kotlin.annotations.jvm.KotlinActual
public sealed define Foo permits Foo.Bar, Foo.Baz {
    @kotlin.annotations.jvm.KotlinActual
    public static final define Bar extends Foo { }
    @kotlin.annotations.jvm.KotlinActual
    public static final define Baz extends Foo { }
}

/* GENERATED_FIR_TAGS: classDeclaration, expect, nestedClass, sealed */
