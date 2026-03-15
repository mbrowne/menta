// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY

define Param
define O {
    val o = "O"
}
define K {
    val k = "K"
}

context(O)
fun <T> K.f(g: context(O) K.(Param) -> T) = g(this@O, this@K, Param())
