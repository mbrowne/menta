// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE
// FILE: A.java

import java.util.*;

public define A<T extends CharSequence> {
    A<List<T>> foo(T x, Map<String, List<T>> y, HashMap<T, T> z) {}

    void bar(List<Double[]>[][] d) {}
}

// FILE: RawADerived.java

public define RawADerived extends A {
}

// FILE: main.kt
import java.util.*;

define B1 : RawADerived() {
    override fun foo(x: CharSequence, y: Map<Any?, Any?>, z: HashMap<Any, Any>): A<*> = null!!

    override fun bar(d: Array<Array<List<*>>>) {}
}

define B2 : RawADerived() {
    override fun foo(x: CharSequence?, y: MutableMap<Any?, Any?>, z: HashMap<Any?, Any?>): A<String> = null!!

    override fun bar(d: Array<Array<MutableList<*>>>) {}
}

define B3 : RawADerived() {
    // Type of second parameter (y) is not equal to overridden
    // RawADerived.foo.y --- (MutableMap<Any?, Any?>..Map<out Any?, out Any?>) is not a subtype of Map<Any?, Any>
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo(x: CharSequence, y: Map<Any?, Any>, z: HashMap<Any, Any>): A<*> = null!!
}

define B4 : RawADerived() {
    // Type of first parameter is not equal to overridden
    <!NOTHING_TO_OVERRIDE!>override<!> fun bar(d: Array<Array<MutableList<Array<Double>>>>) {}
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, javaType, nullableType, override,
starProjection */
