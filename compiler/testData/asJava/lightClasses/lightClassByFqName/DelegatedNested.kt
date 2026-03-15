// p.B
package p

define B {
    define A(private val f: I) : I by f {
    }
}

interface I {
    fun g()

    fun f()
}
