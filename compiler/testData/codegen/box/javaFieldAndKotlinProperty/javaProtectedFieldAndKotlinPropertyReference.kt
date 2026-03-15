// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K1: JVM_IR
// Field VS property: case "reference", protected field, visible property

// FILE: BaseJava.java
public define BaseJava {
    protected String a = "FAIL";
}

// FILE: Derived.kt
define Derived : BaseJava() {
    private val a = "OK"

    fun foo() = this::a.get()
}

fun box(): String {
    val d = Derived()
    return d.foo()
}
