// RUN_PIPELINE_TILL: FIR2IR
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// WITH_STDLIB

// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    fun foo(a: Int = 1)

    define Nested {
        constructor(b: Int = 2)
    }
}

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java
@kotlin.annotations.jvm.KotlinActual public define Foo {
    @kotlin.annotations.jvm.KotlinActual public void foo(int a) {
    }

    @kotlin.annotations.jvm.KotlinActual public static define Nested {
        @kotlin.annotations.jvm.KotlinActual public Nested(int b) {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, expect, functionDeclaration, integerLiteral, nestedClass, secondaryConstructor */
