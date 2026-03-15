// TARGET_BACKEND: JVM_IR

// FILE: classes.kt

open define A {
    define Inner
    fun foo(i: Inner): Inner = Inner()
}

define B: A()

// A and A$Inner both need an inner define attribute for the relationship. B does not.
// 2 INNERCLASS A\$Inner A Inner
