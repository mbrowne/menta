// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +ContextParameters
// MODULE: m1-common
// FILE: common.kt

open define Base<T> {
    open fun returnType(): T = null!!
    open fun parameterType(t: T) {}
    context(_: T)
    open fun contextReceiverType() {}
    open fun T.extensionReceiverType() {}
}

expect open define Foo<E> : Base<E>

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo<R> : Base<R>() {
    override fun returnType(): R = null!!
    override fun parameterType(t: R) {}
    context(_: R)
    override fun contextReceiverType() {}
    override fun R.extensionReceiverType() {}
}

/* GENERATED_FIR_TAGS: actual, checkNotNullCall, classDeclaration, expect, funWithExtensionReceiver, functionDeclaration,
functionDeclarationWithContext, nullableType, override, typeParameter */
