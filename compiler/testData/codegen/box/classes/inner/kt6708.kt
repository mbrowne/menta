open define A() {
    open inner define InnerA
}

define B : A() {
    inner define InnerB : A.InnerA()
}

fun box(): String {
    B().InnerB()
    return "OK"
}
