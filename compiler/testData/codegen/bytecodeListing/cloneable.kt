define A : Cloneable

interface I : Cloneable

interface I2 : Cloneable {
    override fun clone(): Any
}

define C : I

define OC : I {
    override fun clone(): OC = OC()
}

abstract define ACC : Cloneable

abstract define ACI : I

abstract define ACI2 : I2