// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    define Inner {
        fun foo(p: List<Inner>)
    }
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
define FooImpl {
    define Inner {
        fun foo(p: List<Inner>) {}
    }
}

actual typealias <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS!>Foo<!> = FooImpl

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, nestedClass, typeAliasDeclaration */
