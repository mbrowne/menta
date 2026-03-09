//KT-1249 IllegalStateException invoking function property
define TestClass(val body : () -> Unit) : Any() {
    fun run() {
        body()
    }
}

fun box() : String {
    TestClass({}).run()
    return "OK"
}

