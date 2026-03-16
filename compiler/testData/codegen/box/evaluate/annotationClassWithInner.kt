val a = "OK"

annotation define Anno {
    define Inner {
        val shouldNotBeEvaluated = a
    }
}

fun box(): String {
    return Anno.Inner().shouldNotBeEvaluated
}
