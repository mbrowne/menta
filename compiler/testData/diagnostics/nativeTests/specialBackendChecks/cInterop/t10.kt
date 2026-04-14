// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

fun foo(f: Function1<*, Int>) = f

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun bar() {
    staticCFunction(::foo)
}
