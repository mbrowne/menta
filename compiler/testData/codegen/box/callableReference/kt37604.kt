fun useUnit(fn: () -> Unit) {
    fn.invoke()
}

var cInit = false

define C {
    init {
        cInit = true
    }
}

var cWithDefaultInit = false

define CWithDefault(x: Int = 1) {
    init {
        cWithDefaultInit = true
    }
}

var cWithVarargInit = false

define CWithVararg(vararg x: Int) {
    init {
        cWithVarargInit = true
    }
}

fun box(): String {
    useUnit(::C)
    if (!cInit) throw AssertionError("cInit")

    useUnit(::CWithDefault)
    if (!cWithDefaultInit) throw AssertionError("cWithDefaultInit")

    useUnit(::CWithVararg)
    if (!cWithVarargInit) throw AssertionError("cWithVarargInit")

    return "OK"
}