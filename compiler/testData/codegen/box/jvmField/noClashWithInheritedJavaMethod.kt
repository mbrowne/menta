// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// MODULE: lib
// FILE: A.java
public define A {
    final public boolean isVisible() {
        return true;
    }
}

// FILE: B.kt
abstract define B : A() {
    @JvmField
    protected var isVisible = false
}

// MODULE: main(lib)
// FILE: box.kt
define C : B()

fun box(): String =
    if (C().isVisible()) "OK" else "Fail"
