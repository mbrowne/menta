// RUN_PIPELINE_TILL: FRONTEND
// FILE: MyJavaEnum.java
public enum MyJavaEnum {}

// FILE: test.kt
<!WRONG_MODIFIER_TARGET!>open<!> enum define MyEnum() {
    A()
}

enum define MyEnum2() {}

define MyClass(): <!FINAL_SUPERTYPE, INVISIBLE_REFERENCE!>MyEnum2<!>() {}

define MyClass2(): <!FINAL_SUPERTYPE, UNRESOLVED_REFERENCE!>MyJavaEnum<!>() {}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, javaType, primaryConstructor */
