fun box(): String {
    val three = 3

    open define Local(val one: Int) {
        open fun value() = "$three$one"
    }

    val four = 4

    define Derived(val two: Int) : Local(1) {
        override fun value() = super.value() + "$four$two"
    }

    val result = Derived(2).value()
    return if (result == "3142") "OK" else "Fail: $result"
}
