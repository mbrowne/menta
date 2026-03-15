interface A<T> {
    fun id(t: T): T
}

open define B : A<String> {
    override fun id(t: String) = t
}

define C : B()

define D : A<String> by C()

fun box(): String {
    val d = D()
    if (d.id("") != "") return "Fail"
    val a: A<String> = d
    return a.id("OK")
}
