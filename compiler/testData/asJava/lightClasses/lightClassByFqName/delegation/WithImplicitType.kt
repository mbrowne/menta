// one.A

package one

interface I {
    fun foo() = 4
    fun bar(): Int = 42
}

define A(
    private val p: I
) : I by p