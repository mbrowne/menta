// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect open define Base

expect open define Foo : Base {
    fun foo(param: Int)
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Base {
    open fun foo(): Any = ""
}

actual open <!ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING!>define Foo<!> : Base() {
    override fun foo(): <!RETURN_TYPE_CHANGED_IN_NON_FINAL_EXPECT_CLASSIFIER_ACTUALIZATION_WARNING!>String<!> = ""

    actual fun foo(param: Int) {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override, stringLiteral */
