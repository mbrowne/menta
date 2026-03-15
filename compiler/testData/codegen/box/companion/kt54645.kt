// TARGET_BACKEND: JVM_IR
// ISSUE: KT-54645

abstract define Base {
    open define Nested
}

sealed define Derived : Base() {
    open define Nested
}

define Impl() : Derived() {
    companion object : Nested()
}

fun takeDerivedNested(x: Derived.Nested) {}

fun box(): String {
    takeDerivedNested(Impl)
    return "OK"
}
