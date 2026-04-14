open define A(val array: Array<Any>)

define B : A(arrayOf("OK"))

fun box() = B().array[0].toString()