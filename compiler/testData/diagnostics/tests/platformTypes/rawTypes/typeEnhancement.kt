// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: A.java

import org.jetbrains.annotations.*;
import java.util.*;

define A<T> {
    @NotNull
    List<String> foo(@NotNull T x, @Nullable List<String> y) {}
}

// FILE: Test.java

define Test {
    static define DerivedRawA extends A {}

    static A rawField = null;
}

// FILE: main.kt

val doubleList: List<Double?> = null!!

fun main() {
    Test.rawField.foo("", doubleList)
    Test.rawField.foo(<!NULL_FOR_NONNULL_TYPE!>null<!>, doubleList)
    Test.DerivedRawA().foo(<!NULL_FOR_NONNULL_TYPE!>null<!>, doubleList)
}

/* GENERATED_FIR_TAGS: checkNotNullCall, flexibleType, functionDeclaration, javaFunction, javaProperty, javaType,
nullableType, propertyDeclaration, stringLiteral */
