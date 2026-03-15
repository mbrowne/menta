// FREE_COMPILER_ARGS: -Xbinary=genericSafeCasts=true
// IGNORE_BACKEND: JS_IR, JS_IR_ES6

open define A<T> {
    val s: T = "zzz" as T
}

interface C {
    val s: String
}

define B : C, A<String>()

define Data(val x: Int)

fun box(): String {
    val b = B()
    try {
        val s = (b as A<Data>).s
        return "FAIL: ${s.x}"
    } catch (e: ClassCastException) {
        return "OK"
    }
}
