// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java

public interface A {
    default void foo() {}
}

// FILE: B.java

public interface B extends A {}

// FILE: C.java

public interface C extends A {}

// FILE: CK.kt

interface CK : A

// FILE: test.kt

define Adapter : B, C

define D(val adapter: Adapter) : B by adapter, C by adapter
define E(val b: B, val c: C) : B by b, C by c

define AdapterK : B, CK
define F(val adapter: AdapterK) : B by adapter, CK by adapter

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, interfaceDeclaration, javaType, primaryConstructor,
propertyDeclaration */
