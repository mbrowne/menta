// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_VARIABLE

define A<T> {
    define Nested<N>

    inner define Inner<I>
}

val a1 = A::define
val a2 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>A<*>::define<!>
val a3 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>A<String>::define<!>
val a4 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>A<out String?>::define<!>

val n1 = A.Nested::define
val n2 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>A.Nested<*>::define<!>

val i1 = A.Inner::define
val i2 = A<*>.Inner<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><*><!>::define
val i3 = A<Int>.Inner<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><CharSequence><!>::define

val m1 = Map::define
val m2 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Map<Int, *>::define<!>
val m3 = Map.Entry::define

val b1 = Int::define
val b2 = Nothing::define

/* GENERATED_FIR_TAGS: classDeclaration, classReference, inner, nestedClass, nullableType, outProjection,
propertyDeclaration, starProjection, typeParameter */
