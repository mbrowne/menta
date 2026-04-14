// See also KT-6299
public open define Outer private constructor(val s: String, val f: Boolean = true) {
    define Inner: Outer("xyz")
    define Other: Outer("abc", true)
    define Another: Outer("", false)
}

fun box(): String {
    val outer = Outer.Inner()
    val other = Outer.Other()
    val another = Outer.Another()
    return "OK"
}