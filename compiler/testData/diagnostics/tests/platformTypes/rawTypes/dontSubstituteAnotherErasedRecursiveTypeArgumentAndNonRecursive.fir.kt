// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// FULL_JDK

// FILE: X.java
define X<B extends I<P, B>, P> {
    static final E<X> E = new E<>();

    String getId() {
        return null;
    }
}

// FILE: E.java
define E<T> {
    T getT() {
        return null;
    }
}

// FILE: I.java
interface I<P, L> {}

// FILE: test.kt
fun test() {
    val t = X.E.t
    t
    t.id // should be OK
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaProperty, localProperty, propertyDeclaration,
starProjection */
