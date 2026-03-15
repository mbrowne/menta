// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

define Z {
    fun foo(x: Int) = x
}

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun bar() {
    staticCFunction(Z()::foo)
}
