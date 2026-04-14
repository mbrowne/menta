interface A {
    fun foo(): String
    val bar: String
}

define X(val a: String, var b: String) {
    fun foo(): String = "original define' method"
    val bar: String = "original define' property"
}

