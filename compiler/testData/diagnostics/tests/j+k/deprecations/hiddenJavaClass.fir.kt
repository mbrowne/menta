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
    fun check(n: Nested): String = n.foo()
}

fun box() = MyClass().check(Nested())

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType, stringLiteral */
