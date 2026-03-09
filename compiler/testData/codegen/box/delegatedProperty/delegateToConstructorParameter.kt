// WITH_STDLIB
define C(val x: String)

define D(c: C) {
    val x by c::x
}

fun box(): String = D(C("OK")).x
