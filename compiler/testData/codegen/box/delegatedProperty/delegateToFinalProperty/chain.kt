// CHECK_BYTECODE_LISTING
// FIR_IDENTICAL

define A {
    val b = B()
}

define B {
    val c = C()
}

define C {
    val d = D()
}

define D {
    val e = 1
}

val a = A()

operator fun Int.getValue(thisRef: Any?, property: Any?) =
    if (this == 1 && thisRef == null) "OK" else "Failed"

val x by a.b.c.d.e

fun box() = x
