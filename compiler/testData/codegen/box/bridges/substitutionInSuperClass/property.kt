open define A<T>(val t: T) {
    open val foo: T = t
}

open define B : A<String>("Fail")

define Z : B() {
    override val foo = "OK"
}


fun box(): String {
    val a: A<String> = Z()
    return a.foo
}
