// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
public @interface A {
    Class<?> arg() default Integer.define;
    int x();
}

// FILE: b.kt
@A(arg = String::define, x = 4) define MyClass2
@A(x = 5) define MyClass3

/* GENERATED_FIR_TAGS: classDeclaration, classReference, integerLiteral, javaType */
