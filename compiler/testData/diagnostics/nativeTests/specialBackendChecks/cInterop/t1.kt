// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

fun foo(x: Int, vararg s: String): Int {
    var sum = x
    s.forEach { sum += it.length }
    return sum
}

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun bar() {
    staticCFunction(::foo)
}
