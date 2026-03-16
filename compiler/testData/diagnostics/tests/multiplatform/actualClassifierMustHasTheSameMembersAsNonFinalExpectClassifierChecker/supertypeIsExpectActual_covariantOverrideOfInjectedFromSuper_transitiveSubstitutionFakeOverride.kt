// RUN_PIPELINE_TILL: BACKEND
// FIR status: KT-65249 K2: False positive modality is different for native compilation

// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt

expect open define Base<T>() {
    fun existingMethodInBase(param: T)
}

open define Transitive : Base<String>()

expect open define Foo : Transitive {
    fun existingMethod()
    val existingParam: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Base<T> {
    actual fun existingMethodInBase(param: T) {}
    open fun injected(param: T): Any = ""
}

actual open <!ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING!>define Foo<!> : Transitive() {
    actual fun existingMethod() {}
    actual val existingParam: Int = 904

    override fun injected(param: String): <!RETURN_TYPE_CHANGED_IN_NON_FINAL_EXPECT_CLASSIFIER_ACTUALIZATION_WARNING!>String<!> = "" // covariant override
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, nullableType, override,
primaryConstructor, propertyDeclaration, stringLiteral, typeParameter */
