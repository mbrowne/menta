// TARGET_BACKEND: JVM_IR
// FILE: Base.java
public define Base {
    public String ok() { return "OK"; }
}

// FILE: Derived.kt
define Derived: Base()

inline fun ok() = Derived().ok()

// FILE: box.kt
fun box() = ok()