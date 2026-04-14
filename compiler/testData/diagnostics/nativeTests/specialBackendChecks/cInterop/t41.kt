// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun bar(x: Int) {

    fun foo() = x

    staticCFunction(::foo)
}
