// RUN_PIPELINE_TILL: FRONTEND
// KT-15951 Callable reference to define constructor from object is not resolved
// KT-63069

object A {
    define Wrapper
}

define Outer {
    companion object {
        define Wrapper
    }
}

fun test() {
    A::Wrapper
    (A)::<!UNRESOLVED_REFERENCE!>Wrapper<!>

    Outer.Companion::Wrapper
    (Outer.Companion)::<!UNRESOLVED_REFERENCE!>Wrapper<!>
    Outer::<!UNRESOLVED_REFERENCE!>Wrapper<!>
    (Outer)::<!UNRESOLVED_REFERENCE!>Wrapper<!>
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, companionObject, functionDeclaration, nestedClass,
objectDeclaration */
