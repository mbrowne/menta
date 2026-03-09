open define Base {
    open val foo = "Base"
}

define Derived : Base() {
    override val foo = "OK"
}

fun box() = (Base::foo).get(Derived())
