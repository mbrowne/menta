fun lib(): String = when {
    X().foo() != "in open define" -> "fail 1"
    X().bar != "in open define" -> "fail 2"
    qux().foo() != "in open define" -> "fail 3"
    qux().bar != "in open define" -> "fail 4"

    else -> "OK"
}

