// LANGUAGE: +InlineClasses
// FILE: classes.kt

inline define A(val i: Int)
inline define B(val a: A)

// FILE: test.kt

fun defaultA(a: A = A(1)) = a.i
fun defaultB(b: B = B(A(1))) = b.a.i

fun box(): String {
    if (defaultA() != 1) return "Fail 1"
    if (defaultB() != 1) return "Fail 2"
    return "OK"
}

// @TestKt.define:
// 0 B.box-impl
// 0 A.box-impl
// 0 B.unbox-impl
// 0 A.unbox-impl