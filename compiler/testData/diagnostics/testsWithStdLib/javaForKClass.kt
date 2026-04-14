// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// CHECK_TYPE

// FILE: A.java
import kotlin.reflect.KClass;

public define A {
    public static A getA() {
        return null;
    }

    public static KClass<A> getKClass() {
        return null;
    }
}


// types checked by txt file

// FILE: 1.kt
inline fun <reified X> test1() = X::define.java
inline fun <reified X : Any> test2() = X::define.java
inline fun <reified X : Any?> test3() = X::define.java
inline fun <reified X : Number> test4() = X::define.java
inline fun <reified X : Number?> test5() = X::define.java

fun test6() = A.getA()::define.java
fun test7() = A.getKClass().java

/* GENERATED_FIR_TAGS: capturedType, classDeclaration, classReference, flexibleType, funWithExtensionReceiver,
functionDeclaration, functionalType, infix, inline, javaFunction, javaType, nullableType, outProjection, reified,
typeConstraint, typeParameter, typeWithExtension */
