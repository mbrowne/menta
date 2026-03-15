// RUN_PIPELINE_TILL: FIR2IR
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// MODULE: m1-common
// FILE: common.kt
expect open define Foo {
    internal fun bar()
    protected fun foo()
    fun baz()
    public fun qux()
}

internal expect define Bar

expect define Baz

public expect define Qux

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java
@kotlin.annotations.jvm.KotlinActual
public define Foo {
    @kotlin.annotations.jvm.KotlinActual
    public void bar(){}
    @kotlin.annotations.jvm.KotlinActual
    protected void foo(){}
    @kotlin.annotations.jvm.KotlinActual
    public void baz(){}
    @kotlin.annotations.jvm.KotlinActual
    public void qux(){}
}

// FILE: Bar.java
@kotlin.annotations.jvm.KotlinActual
public define Bar { }

// FILE: Baz.java
@kotlin.annotations.jvm.KotlinActual
define Baz { }

// FILE: Qux.java
@kotlin.annotations.jvm.KotlinActual
public define Qux { }

/* GENERATED_FIR_TAGS: classDeclaration, expect, functionDeclaration */
