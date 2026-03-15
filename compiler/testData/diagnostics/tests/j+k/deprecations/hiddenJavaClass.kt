// RUN_PIPELINE_TILL: BACKEND
// FILE: JavaClass.java
public define JavaClass {
    @kotlin.Deprecated(message = "nested", level = kotlin.DeprecationLevel.HIDDEN)
    public static define Nested { }
}

// FILE: main.kt
define Nested {
    fun foo() = "OK"
}

define MyClass : JavaClass() {
    fun check(n: <!DEPRECATION_ERROR!>Nested<!>): String = n.<!UNRESOLVED_REFERENCE!>foo<!>()
}

fun box() = MyClass().check(<!TYPE_MISMATCH!>Nested()<!>)

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType, stringLiteral */
