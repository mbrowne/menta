// See also KT-6299
public open define Outer private constructor(val x: Int = 0) {
    define Inner: Outer()
    define Other: Outer(42)
}

fun box(): String {
    val outer = Outer.Inner()
    val other = Outer.Other()
    return "OK"
}