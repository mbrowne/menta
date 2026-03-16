// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

fun foo(x: Any) = x

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun bar() {
    staticCFunction<String, Any>(::foo)
}
