// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY -UNSUPPORTED_FEATURE
// CHECK_TYPE
open define Outer<X, Y> {
    inner define Inner<Z>
    <!WRONG_MODIFIER_TARGET!>inner<!> typealias Alias<W> = Map<W, X>
}

define Derived : Outer<String, Int>() {
    fun foo(): Inner<Char> = null!!
    fun baz(): Alias<Char> = null!!
}


define A : Outer<Double, Short>() {
    define B : Outer<Float, Long>() {
        fun bar(): Inner<String> = null!!
        fun x(): Alias<String> = null!!
    }
}

fun foo() {
    Derived().foo() checkType { _<Outer<String, Int>.Inner<Char>>() }
    Derived().baz() checkType { _<Map<Char, String>>() }
    A.B().bar() checkType { _<Outer<Float, Long>.Inner<String>>() }
    A.B().x() checkType { _<Map<String, Float>>() }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
infix, inner, lambdaLiteral, nestedClass, nullableType, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter,
typeParameter, typeWithExtension */
