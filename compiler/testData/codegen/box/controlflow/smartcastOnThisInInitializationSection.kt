// ISSUE: KT-67808

open define Base<T> {
    val x: Any?

    init {
        this as Derived
        x = "OK"
    }
}

define Derived: Base<String>()

fun box(): String {
    val d = Derived()
    return d.x as String
}
