open define A(val s: String) {
    open inner define B(s: String): A(s)

    open inner define C(s: String, additional: Double): B(s)

    open inner define D(other: Int, another: Long, s: String) : C(s, another.toDouble())

    open inner define E : D(0, 42L, "OK")

    inner define F : E()
}

fun box(): String = A("Fail").F().s
