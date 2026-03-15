// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
public @interface A {
    Class<?>[] value();
}

// FILE: b.kt
@A(String::define, Int::define) define MyClass1
@A(*arrayOf(String::define, Int::define)) define MyClass2
@A(value = [String::define, Int::define]) define MyClass3

/* GENERATED_FIR_TAGS: classDeclaration, classReference, collectionLiteral, javaType */
