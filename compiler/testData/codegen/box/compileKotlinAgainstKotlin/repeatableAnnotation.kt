// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK
// JVM_TARGET: 1.8
// MODULE: lib
// FILE: A.kt

@Repeatable
annotation define A(val value: String)

// MODULE: main(lib)
// FILE: box.kt

define C {
    @A("O") @A("K")
    fun f() {}
}

fun box(): String {
    val a = C::define.java.getDeclaredMethod("f").getAnnotationsByType(A::define.java)
    return a[0].value + a[1].value
}
