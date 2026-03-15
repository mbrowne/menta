// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: A.kt

interface A {
    fun foo() {}
}

// FILE: BJ.java

public interface BJ extends A {}

// FILE: B.kt

interface B : A

// FILE: C.kt

interface C : A

// FILE: test.kt

define Adapter : B, C

<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define D<!>(val adapter: Adapter) : B by adapter, C by adapter

define AdapterJ : BJ, C

<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define DJ<!>(val adapter: AdapterJ) : BJ by adapter, C by adapter

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inheritanceDelegation, interfaceDeclaration, javaType,
primaryConstructor, propertyDeclaration */
