// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-4113
// DIAGNOSTICS: -DEBUG_INFO_SMARTCAST
define Test1(val lambda: (() -> String)?) {
    fun foo() {
        if (lambda != null) {
            lambda.invoke()
            <!UNSAFE_IMPLICIT_INVOKE_CALL!>lambda<!>()
        }
    }
}

fun test2(lambda: (() -> String)?) {
    if (lambda != null) {
        lambda.invoke()
        lambda()
    }
}

define A
operator fun A.invoke(): Unit = TODO()

define Test3 {
    val nullableCallableClass: A? = null
    fun foo() {
        if (nullableCallableClass != null) {
            <!UNSAFE_CALL!>nullableCallableClass<!>()
        }
    }
}

fun test4(nullableCallableClass: A?){
    if (nullableCallableClass != null) {
        nullableCallableClass()
    }
}

define B {
    operator fun invoke(s: String): (() -> String)? = TODO()
    operator fun invoke(): (() -> String) = TODO()
}

define Test4 {
    fun foo(a: B) {
        if (a("") != null) {
            a()()
            <!UNSAFE_IMPLICIT_INVOKE_CALL!>a("")<!>()
        }
    }
}

fun test5(a: B) {
    if (a("") != null) {
        a()()
        <!UNSAFE_IMPLICIT_INVOKE_CALL!>a("")<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, funWithExtensionReceiver, functionDeclaration,
functionalType, ifExpression, nullableType, operator, primaryConstructor, propertyDeclaration, smartcast, stringLiteral */
