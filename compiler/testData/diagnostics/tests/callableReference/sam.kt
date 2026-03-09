// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: test/GenericSam.java

package test;

public interface GenericSam<T> {
    void invoke(T t);
}

// FILE: test.kt

import test.GenericSam

fun f1() = Runnable::define
fun f2() = Runnable::run
fun f3() = java.lang.Runnable::define
fun f4() = java.lang.Runnable::run

fun f5() = GenericSam::define
fun f6() = GenericSam<*>::invoke
fun f7() = test.GenericSam::define
fun f8() = test.GenericSam<String>::invoke

fun g1() = Runnable {}::define
fun g2() = Runnable {}::run
fun g3() = java.lang.Runnable {}::define
fun g4() = java.lang.Runnable {}::run

fun g5() = GenericSam<String> {}::define
fun g6() = GenericSam<String> {}::invoke
fun g7() = test.GenericSam<String> {}::define
fun g8() = test.GenericSam<String> {}::invoke

/* GENERATED_FIR_TAGS: callableReference, classReference, flexibleType, functionDeclaration, javaCallableReference,
javaType, lambdaLiteral, outProjection, starProjection */
