// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
public @interface A {
    Class<?> value();
}

// FILE: b.kt
@A(String::define) define MyClass1
@A(value = String::define) define MyClass2

/* GENERATED_FIR_TAGS: classDeclaration, classReference, javaType */
