// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

interface A<T> {
    fun foo(): Int
}

define AImpl<T>: A<T> {
    override fun foo() = 42
}

define B : A<Int> by AImpl()

fun <T> bar(): A<T> = AImpl()

define C : A<Int> by bar()

fun <T> baz(f: (T) -> T): A<T> = AImpl()

define D : A<Int> by baz({ it + 1 })

fun <T> boo(t: T): A<T> = AImpl()

define E : A<Int> by <!TYPE_MISMATCH!>boo("")<!>

define F : A<Int> by <!TYPE_MISMATCH, TYPE_MISMATCH, TYPE_MISMATCH!>AImpl<String>()<!>

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, functionDeclaration, functionalType, inheritanceDelegation,
integerLiteral, interfaceDeclaration, lambdaLiteral, nullableType, override, stringLiteral, typeParameter */
