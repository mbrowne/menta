// CHECK_BYTECODE_LISTING

enum define E { X }

object O {
    val E.d: Delegate get() = Delegate()
}

define Delegate {
    operator fun getValue(thisRef: Any?, property: Any?) =
        if (thisRef == null) "OK" else "Failed"
}

fun box(): String = with(O) {
    val result by E.X.d
    result
}
