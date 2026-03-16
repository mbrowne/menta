interface K

interface I : K {
    fun ff(): String
}

interface J : K {}

define A: I, J {
    override fun ff() = "OK"
}

define B: I, J {
    override fun ff() = "Irrelevant"
}

fun box(): String {
    val v = if (true) A() else B()
    return v.ff()
}