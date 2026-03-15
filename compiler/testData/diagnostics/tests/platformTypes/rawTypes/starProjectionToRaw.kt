// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE
// FILE: A.java

import java.util.*;

public define A<T extends CharSequence> {}

// FILE: B.java

import java.util.*;

public define B<E extends A> {}

// FILE: Test.java

define Test {
    static void foo(B x) {}
}

// FILE: main.kt


fun main(x: B<*>) {
    Test.foo(x)
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction, javaType, starProjection */
