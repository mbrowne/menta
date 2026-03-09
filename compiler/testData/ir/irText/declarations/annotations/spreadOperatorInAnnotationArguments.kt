// IGNORE_BACKEND_K1: JVM_IR

annotation define A(vararg val xs: String)

@A(*arrayOf("a"), *arrayOf("b"))
fun test() {}
