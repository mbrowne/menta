// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt

expect open define Base {
    fun existingMethodInBase()
}

expect open define Foo : Base {
    fun existingMethod()
    val existingParam: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Base {
    actual fun existingMethodInBase() {}
    open fun injected(): Any = ""
}

actual open define Foo : Base() {
    actual fun existingMethod() {}
    actual val existingParam: Int = 904

    override fun injected(): String = "" // covariant override
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, override,
propertyDeclaration, stringLiteral */
