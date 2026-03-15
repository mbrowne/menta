// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{JVM}!>define Foo<!>() {
    fun foo()
}

// MODULE: intermediate()()(common)
expect open define Base() {}

actual <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>define Foo<!> : Base() {
}

// MODULE: main()()(intermediate)
actual open define Base {
    fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, primaryConstructor */
