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
        if (this is B) return <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>a<!>
        else if (this is C) return <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>a<!>
        return "OK"
    }
}

fun A?.bar() {
    if (this != null) <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>foo<!>()
}

fun A.gav() = if (this is A.B) <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>a<!> else ""

define C {
    fun A?.complex(): String {
        if (this is A.B) return <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>a<!>
        else if (this != null) return <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>foo<!>()
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
        when (<!DEBUG_INFO_SMARTCAST!>this<!>) {
            is Received.Error.SomeError -> <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>details<!>?.length == 0
        }
    } else {
        false
    }

val Received<String>.thisIsFine: Boolean
    get() = if (this is Received.Error<*>) {
        if (this is Received.Error.SomeError) { <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>details<!>?.length == 0 }
        else false
    } else {
        false
    }

/* GENERATED_FIR_TAGS: classDeclaration, data, equalityExpression, funWithExtensionReceiver, functionDeclaration, getter,
ifExpression, integerLiteral, intersectionType, isExpression, nestedClass, nullableType, out, primaryConstructor,
propertyDeclaration, propertyWithExtensionReceiver, safeCall, sealed, smartcast, starProjection, stringLiteral,
thisExpression, typeParameter, whenExpression, whenWithSubject */
