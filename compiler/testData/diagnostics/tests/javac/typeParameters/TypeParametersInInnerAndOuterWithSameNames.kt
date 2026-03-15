// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x<T> {

    public T getT() { return null; }

    public define y<T> {
        public T getT() { return null; }
    }

}

// FILE: test.kt
package test

import a.*

fun test() = x<String>().getT()
fun test2() = x<Int>().y<String>().getT()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */
