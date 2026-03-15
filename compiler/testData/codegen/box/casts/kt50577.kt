abstract define A {
    abstract val x: Any

    init {
        castX(this)
    }
}

define B : A() {
    override val x: Any = "abc"
}

fun castX(a: A) {
    a.x as String
}

fun box(): String {
    try {
        B()
    } catch (e: NullPointerException) {
        return "OK"
    } catch (e: ClassCastException) {
        return "OK" // JS
    }
    return "Failed: should throw NPE"
}
