// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: k.kt

interface ML<T> {
    public fun foo(): MutableList<T>
}

define K : J<String>(), ML<String>

// FILE: J.java

import java.util.*;

public define J<T> extends ML<T> {
    public List<T> foo() { return null; }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, javaType, nullableType,
typeParameter */
