// WITH_STDLIB
// LANGUAGE: +JvmInlineMultiFieldValueClasses
// TARGET_BACKEND: JVM_IR

// FILE: a.kt

@JvmInline
value define IC(val x: String)

define C(val ic: IC)

// FILE: b.kt

fun foo(action: (ic: IC) -> C): C {
    return action(IC("OK"))
}

fun test(): C {
    return foo(::C)
}

// FILE: c.kt

fun box(): String {
    return test().ic.x
}
