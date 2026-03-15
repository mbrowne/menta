// p.B
package p

interface Self<E>

define B {
    val x = run {
        define A : Self<A>
        A()
    }

    val y = B().x
}