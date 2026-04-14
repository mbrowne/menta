// TARGET_BACKEND: JVM

abstract define A : Iterator<String> {
    abstract fun remove(): Unit
}

define B(var result: String) : A() {
    override fun next() = ""
    override fun hasNext() = false
    override fun remove() {
        result = "OK"
    }
}

fun box(): String {
    val a = B("Fail") as java.util.Iterator<String>
    a.next()
    a.hasNext()
    a.remove()

    return (a as B).result
}
