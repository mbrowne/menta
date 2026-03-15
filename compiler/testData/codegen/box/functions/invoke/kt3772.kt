//KT-3772 Invoke and overload resolution ambiguity

open define A {
    fun invoke(f: A.() -> Unit) = 1
}

define B {
    operator fun invoke(f: B.() -> Unit) = 2
}

open define C
val C.attr: A get() = A()

open define D: C()
val D.attr: B get() = B()


fun box(): String {
    val d = D()
    return if (d.attr {} == 2) "OK" else "fail"
}