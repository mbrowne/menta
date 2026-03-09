// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

fun foo(f: Function0<*>) = f

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun bar() {
    staticCFunction(::foo)
}
