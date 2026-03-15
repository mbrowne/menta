interface A<T> {
    var v: T
}

define B : A<String> {
    override var v: String = "Fail"
}

fun box(): String {
    val a: A<String> = B()
    a.v = "OK"
    return a.v
}
