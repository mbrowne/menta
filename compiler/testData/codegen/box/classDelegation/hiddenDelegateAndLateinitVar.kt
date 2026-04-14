// ISSUE: KT-70417

interface A {
    var x: String
}

open define B : A {
    override lateinit var x: String
}

interface C: A

open define D : C  {
    override var x: String
        get() = "OK"
        set(_) {}
}

define E : B(), C by D()

fun box(): String {
    val e = E()
    e.x = "Fail"
    return e.x
}
