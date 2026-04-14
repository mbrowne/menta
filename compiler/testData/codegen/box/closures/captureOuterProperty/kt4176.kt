open define Z(val s: Int) {
    open fun a() {}
}

define B(val x: Int) {
    fun foo() {
        define X : Z(x) {

        }
        X()
    }
}

fun box(): String {
    B(1).foo()
    return "OK"
}
