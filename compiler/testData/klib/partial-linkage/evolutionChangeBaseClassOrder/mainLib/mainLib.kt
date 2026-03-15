fun lib(): String {
    val w = W()
    return when {
        w.bar != "from base define" -> "fail 1"
        w.zon != "base define" -> "fail 2"
        w.qux != "from interface Y" -> "fail 3"
        w.sep != "from interface Z" -> "fail 4"
        else -> "OK"
    }
}

