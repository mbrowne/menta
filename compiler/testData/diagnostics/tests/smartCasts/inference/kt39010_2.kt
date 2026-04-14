// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A<E> {
}

define B : A<String>() {
    fun foo() {}
}

interface KI {
    val a: A<*>
}

fun KI.bar() {
    if (a is B) {
        <!SMARTCAST_IMPOSSIBLE!>a<!>.foo()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, ifExpression,
interfaceDeclaration, isExpression, nullableType, propertyDeclaration, smartcast, starProjection, typeParameter */
