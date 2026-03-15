interface A {
    val result: String
}

define Base(override val result: String) : A

open define Derived : A by Base("OK")

define Z : Derived()

fun box() = Z().result
