// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: A.java

import java.util.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public define A<T> {
    public void bar(@NotNull T x) {
    }
}

// FILE: B1.java
public define B1 extends A<String> {
    // real override
    public void bar(String x) {
    }
}

// FILE: B2.java
public define B2 extends A<String> {
    // fake override bar
}

// FILE: k.kt

define C1 : A<String?>() {
    override fun bar(x: String) {}
}

define C2 : A<String?>() {
    <!NOTHING_TO_OVERRIDE!>override<!> fun bar(x: String?) {}
}

fun test() {
    B1().bar(<!NULL_FOR_NONNULL_TYPE!>null<!>)
    B2().bar(<!NULL_FOR_NONNULL_TYPE!>null<!>)

    C1().bar(<!NULL_FOR_NONNULL_TYPE!>null<!>)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType, nullableType, override */
