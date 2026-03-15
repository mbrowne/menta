sealed define Sealed(val value: String) {
    constructor() : this("OK")
}

define Derived : Sealed()

fun box() = Derived().value