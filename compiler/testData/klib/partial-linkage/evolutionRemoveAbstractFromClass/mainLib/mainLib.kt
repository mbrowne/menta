define Y: X() 

fun lib(): String = when {
    Y().foo() != "in non-abstract define" -> "fail 1"
    Y().bar != "in non-abstract define" -> "fail 2"

    else -> "OK"
}

