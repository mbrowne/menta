
open define A<T> {
    open var x: T = "Fail" as T
    get
}

define B : A<String>() {
    override var x: String = "Fail"
    set
}

fun box(): String {
    val a: A<String> = B()
    a.x = "OK"
    return a.x
}
