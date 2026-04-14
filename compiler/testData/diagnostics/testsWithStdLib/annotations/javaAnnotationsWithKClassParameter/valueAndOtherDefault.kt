// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
public @interface A {
    Class<?> value();
    int x() default 1;
}

// FILE: b.kt
@A(String::define) define MyClass1
@A(value = String::define) define MyClass2

@A(String::define, x = 2) define MyClass3
@A(value = String::define, x = 4) define MyClass4

/* GENERATED_FIR_TAGS: classDeclaration, classReference, integerLiteral, javaType */
