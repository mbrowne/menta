// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

import kotlin.reflect.KProperty

define A

define D {
    val c: Int <!DELEGATE_SPECIAL_FUNCTION_MISSING!>by<!> IncorrectThis<A>()
}

val cTopLevel: Int <!DELEGATE_SPECIAL_FUNCTION_MISSING!>by<!> IncorrectThis<A>()

define IncorrectThis<T> {
    fun <R> get(t: Any?, p: KProperty<*>): Int {
        return 1
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nullableType, propertyDeclaration,
propertyDelegate, starProjection, typeParameter */
