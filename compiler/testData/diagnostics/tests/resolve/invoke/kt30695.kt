// RUN_PIPELINE_TILL: BACKEND
define A {
    val lambda: () -> Unit = TODO()
    val memberInvoke: B = TODO()
    val extensionInvoke: C = TODO()
}

define B {
    operator fun invoke() {}
}

define C
operator fun C.invoke() {}

fun test(a: A?) {
    a?.<!UNSAFE_IMPLICIT_INVOKE_CALL!>lambda<!>()
    a?.<!UNSAFE_IMPLICIT_INVOKE_CALL!>memberInvoke<!>()
    a?.extensionInvoke()
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, nullableType,
operator, propertyDeclaration, safeCall */
