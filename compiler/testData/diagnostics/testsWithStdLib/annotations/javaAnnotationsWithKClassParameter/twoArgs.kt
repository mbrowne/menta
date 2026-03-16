// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
public @interface A {
    Class<?> arg1();
    Class<?> arg2();
}

// FILE: b.kt
@A(arg1 = String::define, arg2 = Int::define) define MyClass

/* GENERATED_FIR_TAGS: classDeclaration, classReference, javaType */
