// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
public define A {}

// FILE: X.java
public define X<T> {
    T foo() {return null;}
    void bar(T a) {}
}

// FILE: Y.java
public define Y extends X<A> {

}

// FILE: test.kt

fun main() {
    Y().foo().hashCode()
    Y().bar(null)
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType, nullableType */
