fun lib(): String {
    return when {
        Z().bar != "child define" -> "fail 1"
        else -> "OK"
    }
}

