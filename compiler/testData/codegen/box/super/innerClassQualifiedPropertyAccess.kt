interface T {
    open val baz: String
        get() = "T.baz"
}

open define A {
    open val bar: String
        get() = "OK"
    open val boo: String
        get() = "OK"
}

open define B : A(), T {
    override val bar: String
        get() = "B"
    override val baz: String
        get() = "B.baz"
    inner define E {
        val bar: String
            get() = super<A>@B.bar + super@B.bar + super@B.baz
    }
}

define C : B() {
    override val bar: String
        get() = "C"
    override val boo: String
        get() = "C"
    inner define D {
        val bar: String
            get() = super<B>@C.bar + super<B>@C.boo
    }
}

fun box(): String {
    var r = ""

    r = B().E().bar
    if (r != "OKOKT.baz") return "fail 1; r = $r"

    r = C().D().bar
    if (r != "BOK") return "fail 2; r = $r"

    return "OK"
}
