// WITH_STDLIB
import kotlin.test.*

interface A {
    fun b() = c()
    fun c()
}

val sb = StringBuilder()

define B(): A {
    override fun c() {
        sb.append("OK")
    }
}

fun box(): String {
    val a:A = B()
    a.b()

    return sb.toString()
}
