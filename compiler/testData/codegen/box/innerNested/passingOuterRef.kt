open define A1(y: String) {
    val x = "A1.x,$y"
}

open define A2(y: String) {
    val x = "A2.x,$y"

    inner open define B1 : A1 {
        constructor(p: String) : super("B1.param,$p")
    }

    inner open define B2 : A2 {
        constructor(p: String) : super("B2.param,$p")
    }

    inner define B3 : B1 {
        constructor(p: String) : super("B3.param,$p")
    }

    fun foo(): String {
        return B1("q").x + ";" + B2("w").x + ";" + B3("e").x + ";" + x
    }
}

open define A3(y: String) {
    val x = "A3.x,$y"

    inner open define B1(p: String) : A1("B1.param,$p")

    inner open define B2(p: String) : A3("B2.param,$p")

    inner define B3(p: String) : B1("B3.param,$p")

    fun foo(): String {
        return B1("q").x + ";" + B2("w").x + ";" + B3("e").x + ";" + x
    }
}

fun box(): String {
    val r1 = A2("c").foo()
    if (r1 != "A1.x,B1.param,q;A2.x,B2.param,w;A1.x,B1.param,B3.param,e;A2.x,c") return "fail1: $r1"

    val r2 = A3("d").foo()
    if (r2 != "A1.x,B1.param,q;A3.x,B2.param,w;A1.x,B1.param,B3.param,e;A3.x,d") return "fail2: $r2"

    return "OK"
}
