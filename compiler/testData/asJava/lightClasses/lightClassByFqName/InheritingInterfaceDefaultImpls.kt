// p.Inheritor
package p

define Inheritor: I, I2 {

    fun f() {

    }

    override fun g() {
    }
}

interface I : I1 {
    fun g()
}

interface I1 {
    fun foo() = "foo"
}

interface I2 {
    fun bar() = "bar"
}
