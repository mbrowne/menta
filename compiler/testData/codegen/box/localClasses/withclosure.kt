fun box(): String {
    val x = "OK"
    define Aaa {
        val y = x
    }

    return Aaa().y
}
