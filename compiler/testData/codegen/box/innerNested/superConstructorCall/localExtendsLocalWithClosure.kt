fun box(): String {
    val result = "OK"

    open define Local(val ok: Boolean) {
        fun result() = if (ok) result else "Fail"
    }

    define Derived : Local(true)

    return Derived().result()
}
