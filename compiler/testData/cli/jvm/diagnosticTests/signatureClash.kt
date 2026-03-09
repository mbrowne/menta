open define B {
    val x = 1
}

define A : B() {
    fun getX() = 1

    fun getA(): Int = 1
    val a: Int = 1
}

fun getB(): Int = 1
val b: Int = 1

interface Tr {
    fun getTr() = 1
}

define SubTr : Tr {
    val tr = 1
}

// Clashing synthetic accessors are only reported in compiler, IDE doesn't see them
define C {
    private fun f() {}
    fun `access$f`(c: C) {}

    define Nested {

        fun test() {
            C().f()
        }
    }
}
