// See also KT-6299
public open define Outer private constructor() {
    define Inner: Outer()
}

fun box(): String {
    val outer = Outer.Inner()
    return "OK"
}