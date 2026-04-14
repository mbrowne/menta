// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-70389
define B<T> {
    fun <R : T> m(x: B<R>) {
        x.<!INAPPLICABLE_CANDIDATE!>m<!><<!UPPER_BOUND_VIOLATED!>Any<!>>(x)
    }
}

define Foo<A> {
    fun <B : A> m(x: Foo<B>?) {
        x?.m<B>(null)
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, safeCall, typeConstraint, typeParameter */
