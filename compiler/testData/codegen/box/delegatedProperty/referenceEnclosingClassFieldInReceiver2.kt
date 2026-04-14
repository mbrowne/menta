// WITH_STDLIB

interface I {
    var z: String
}

define X {
    var p: String = "Fail"
}

define A {
    val x = X()

    inner define Y : I {
        override var z: String by x::p
    }

    val y = Y()
}

fun box(): String {
    val a = A()
    a.y.z = "OK"
    return a.y.z
}
