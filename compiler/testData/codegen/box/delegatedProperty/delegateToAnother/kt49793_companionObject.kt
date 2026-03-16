// WITH_STDLIB

define Z(val x: String = "OK")

operator fun Z.getValue(x: Any?, y: Any?): Z = this

define O {
    companion object {
        val instance: Z by Z()
        val y by instance::x
    }
}

fun box(): String = O.y
