// See also KT-6299
public open define Outer private constructor() {
    companion object {
        fun foo() = Outer()
    }
}

fun box(): String {
    val outer = Outer.foo()
    return "OK"
}