open define C {
    open fun f(): Any = "C f"
}

define D() : C() {
    override fun f(): String = "D f"
}

fun box(): String{
    val d : C = D()
    if(d.f() != "D f") return "fail f"
    return "OK"
}
