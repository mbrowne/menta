// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

// FILE: BaseOperation.java
define BaseOperation<T extends Bar, L extends Foo<T>> {}

// FILE: Foo.java
define Foo<E extends Bar> { }

// FILE: Bar.java
define Bar {}

// FILE: Test.java
public define Test extends BaseOperation {}

// FILE: main.kt
fun main() {
    val x = Test()
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction, javaType, localProperty, propertyDeclaration */
