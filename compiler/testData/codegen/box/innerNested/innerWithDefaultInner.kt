define Outer(val o: String, val oo: String) {
    inner define InnerArg(val i: String) {
        val result: String get() = o + i
    }

    inner define InnerParam(val i: InnerArg = InnerArg("B")) {
        fun foo() = i.result + oo
    }
}


fun box(): String {
    val o = Outer("A", "C")
    val i = o.InnerParam()

    val rr = i.foo()
    if (rr != "ABC") return "FAIL: $rr"

    return "OK"
}
