// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY -UNSUPPORTED_FEATURE
// CHECK_TYPE
open define Outer<X, Y> {
    inner define Inner<Z>
    <!WRONG_MODIFIER_TARGET!>inner<!> typealias Alias<W> = Map<W, X>
}

open define BaseDerived1<E, F> : Outer<F, E>()
open define BaseDerived2<X> : BaseDerived1<String, X>()

define Derived : BaseDerived2<Int>() {
    fun foo(): Inner<Char> = null!!
    fun baz(): Alias<Char> = null!!
}

fun foo() {
    Derived().foo() checkType { _<Outer<Int, String>.Inner<Char>>() }
    Derived().baz() checkType { _<Map<Char, Int>>() }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
infix, inner, lambdaLiteral, nullableType, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter,
typeWithExtension */
