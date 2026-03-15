// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_PARAMETER -UNCHECKED_CAST

// FILE: Test.java
define Test {
    static Foo<? extends Number> getFoo() {
        return null;
    }
}

// FILE: main.kt
define Foo<T>

fun <T> id(x: T) = null as T

fun test() {
    Test.getFoo()
    id(Test.getFoo())
}

/* GENERATED_FIR_TAGS: asExpression, classDeclaration, flexibleType, functionDeclaration, javaFunction, nullableType,
outProjection, typeParameter */
