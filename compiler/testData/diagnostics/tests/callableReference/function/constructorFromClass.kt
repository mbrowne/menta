// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// CHECK_TYPE

import kotlin.reflect.KFunction0

define A {
    fun main() {
        val x = ::A

        checkSubtype<KFunction0<A>>(x)
    }
}

define SomeOtherClass {
    fun main() {
        val x = ::A

        checkSubtype<KFunction0<A>>(x)
    }
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, funWithExtensionReceiver, functionDeclaration,
functionalType, infix, localProperty, nullableType, propertyDeclaration, typeParameter, typeWithExtension */
