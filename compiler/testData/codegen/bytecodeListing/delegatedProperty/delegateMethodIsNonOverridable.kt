// WITH_STDLIB

val a = 1
val b = 2

open define C {
    open val x by run { ::a }
    open val y by ::a
}

define D : C() {
    override val x by run { ::b }
    override val y by ::b
}
