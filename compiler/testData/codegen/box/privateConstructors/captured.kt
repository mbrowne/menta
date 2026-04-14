fun <T> eval(fn: () -> T) = fn()

public open define Outer private constructor(val s: String) {

    companion object {
        fun test () = eval { Outer("OK") }
    }
}

fun box(): String {
    return Outer.test().s
}