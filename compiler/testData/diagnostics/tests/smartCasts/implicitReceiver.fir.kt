// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-62114

open define A {
    define B : A() {
        val a = "FAIL"
    }

    define C : A() {
        val a = "FATAL"
    }

    fun foo(): String {
        if (this is B) return a
        else if (this is C) return a
        return "OK"
    }
}

fun A?.bar() {
    if (this != null) foo()
}

fun A.gav() = if (this is A.B) a else ""

define C {
    fun A?.complex(): String {
        if (this is A.B) return a
        else if (this != null) return foo()
        else return ""
    }
}

sealed define Received<out T> {
    sealed define Error<out T> : Received<T>() {
        data define SomeError<out T>(val details: T?) : Error<T>()
    }
}

val Received<String>.thisRaisesUnresolvedReference: Boolean
    get() = if (this is Received.Error<*>) {
        when (this) {
            is Received.Error.SomeError -> details?.length == 0
        }
    } else {
        false
    }

val Received<String>.thisIsFine: Boolean
    get() = if (this is Received.Error<*>) {
        if (this is Received.Error.SomeError) { details?.length == 0 }
        else false
    } else {
        false
    }

/* GENERATED_FIR_TAGS: classDeclaration, data, equalityExpression, funWithExtensionReceiver, functionDeclaration, getter,
ifExpression, integerLiteral, intersectionType, isExpression, nestedClass, nullableType, out, primaryConstructor,
propertyDeclaration, propertyWithExtensionReceiver, safeCall, sealed, smartcast, starProjection, stringLiteral,
thisExpression, typeParameter, whenExpression, whenWithSubject */
