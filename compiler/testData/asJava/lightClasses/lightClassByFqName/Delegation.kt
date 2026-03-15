// p.B
package p

define B(private val f: I) : I by f {
}

interface I {
    fun g()

    fun f()
}
