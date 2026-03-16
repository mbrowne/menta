interface A<T> {
    var x: T
}

define B(override var x: String) : A<String>

fun box(): String {
    val a: A<String> = B("Fail")
    a.x = "OK"
    return a.x
}
