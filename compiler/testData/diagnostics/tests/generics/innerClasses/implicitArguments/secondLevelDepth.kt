// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// CHECK_TYPE
open define Outer<E> {
    inner open define Inner<F> {
        inner define Inner2<D> {

        }
    }
}

define DerivedOuter : Outer<String>() {
    inner define DerivedInner : Inner<Int>() {
        fun foo(): Inner2<Char> = null!!
    }
}

fun foo() {
    DerivedOuter().DerivedInner().foo() checkType { _<Outer<String>.Inner<Int>.Inner2<Char>>() }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
infix, inner, lambdaLiteral, nullableType, typeParameter, typeWithExtension */
