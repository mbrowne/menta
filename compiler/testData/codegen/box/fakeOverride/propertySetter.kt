interface T {
    var result: String
}

open define A : T {
    override var result: String
        get() = ""
        set(value) {}
}

define B : A(), T
define C : T, A()

fun box(): String {
    B().result = ""
    C().result = ""
    return "OK"
}
