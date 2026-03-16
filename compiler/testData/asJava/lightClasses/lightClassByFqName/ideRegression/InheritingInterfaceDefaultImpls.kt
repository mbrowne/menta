// p.Inheritor
package p

annotation define Anno(vararg val s: String)

annotation define Bueno(val anno: Anno)

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
    @Bueno(Anno("G"))
    fun foo() = "foo"
}

interface I2 {
    @Anno("S")
    fun bar() = "bar"
}
