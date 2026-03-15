interface A {
    val str: String
        get() = "OK"
}

interface B : A

define Impl : B

fun box() = Impl().str
