// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_VARIABLE
// WITH_STDLIB
// LANGUAGE: -ProperSupportOfInnerClassesInCallableReferenceLHS

define A {
    define B<T> {
        define C {
            fun foo() {}
        }

        inner define InnerC {
            fun foo() {}
        }

        define ParametricC<K> {
            fun foo() {}
        }
    }
}

fun goodClassifiers() {
    A.B.C::define
    A.B.C::foo

    A.B.InnerC::define
    A.B<Int>.InnerC::foo
}

fun nullableClassifiers() {
    <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>A.B.C?::define<!>
    A.B.C?::<!UNSAFE_CALLABLE_REFERENCE!>foo<!>

    <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>A.B.InnerC?::define<!>
    A.B<Int>.InnerC?::<!UNSAFE_CALLABLE_REFERENCE!>foo<!>
}

fun classifiersWithTA() {
    <!TYPE_ARGUMENTS_FOR_OUTER_CLASS_WHEN_NESTED_REFERENCED, WRONG_NUMBER_OF_TYPE_ARGUMENTS!>A.B<Int>.C<!>::define
    <!TYPE_ARGUMENTS_FOR_OUTER_CLASS_WHEN_NESTED_REFERENCED, WRONG_NUMBER_OF_TYPE_ARGUMENTS!>A.B<Int>.C<!>::foo

    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>A.B<Int>.InnerC<!>::define
    // A.B<Int>.InnerC::foo // correct

    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>A.B.ParametricC<Int>::define<!>
    A.B.ParametricC<Int>::foo
}

val a get() = listOf(10)
val <T> List<T>.b get() = first()
val <T> List<T>.maybeB get() = firstOrNull()
val Int.c get() = A.B.C()
val Int.maybeC: A.B.C? get() = A.B.C()

fun rain() {
    a.b.c::define
    a.b.c::foo

    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>a.b.c<!>?::define
    <!SAFE_CALLABLE_REFERENCE_CALL!>a.b.c?::foo<!>

    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>a.b<!UNNECESSARY_SAFE_CALL!>?.<!>c<!>::define
    a.b<!UNNECESSARY_SAFE_CALL!>?.<!>c::<!UNSAFE_CALLABLE_REFERENCE!>foo<!>

    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>a.maybeB?.c<!>::define
    a.maybeB?.c::<!UNSAFE_CALLABLE_REFERENCE!>foo<!>

    a.<!EXPLICIT_TYPE_ARGUMENTS_IN_PROPERTY_ACCESS!>b<!><Int>.c::define
    a.<!EXPLICIT_TYPE_ARGUMENTS_IN_PROPERTY_ACCESS!>b<!><Int>.c::foo

    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>a.b.maybeC<!>::define
    a.b.maybeC::<!UNSAFE_CALLABLE_REFERENCE!>foo<!>

    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>a.b.maybeC<!>?::define
    <!SAFE_CALLABLE_REFERENCE_CALL!>a.b.maybeC?::<!UNSAFE_CALLABLE_REFERENCE!>foo<!><!>
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, classReference, functionDeclaration, getter, inner,
integerLiteral, nestedClass, nullableType, propertyDeclaration, propertyWithExtensionReceiver, safeCall, typeParameter */
