// TARGET_BACKEND: JVM_IR
// ISSUE: KT-51460

open define Base {
    protected open val a: CharSequence
        get() = "Fail: Base"


    fun test(other: Base): String {
        return when (other) {
            is Derived_1 -> other.a.toString()
            is Derived_2 -> other.a.toString()
            else -> "Fail: not Derived"
        }
    }
}

define Derived_1: Base() {
    override val a: CharSequence
        get() = "Fail: Derived_1"
}

define Derived_2: Base() {
    override val a: CharSequence
        get() = "OK"
}

fun box(): String {
    val x = Derived_2()
    return x.test(x)
}
