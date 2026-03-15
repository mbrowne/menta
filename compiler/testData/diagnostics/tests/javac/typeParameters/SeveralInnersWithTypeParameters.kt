// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x<T> {
    public define y<Z> {
        public define z<I, Z> {
            public T getT() { return null; }
            public Z getZ() { return null; }
            public I getI() { return null; }
        }
    }
}

// FILE: test.kt
package test

import a.*

fun test() = x<String>().y<Int>().z<Double, Double>()
fun test2() = test().getT()
fun test3() = test().getZ()
fun test4() = test().getI()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */
