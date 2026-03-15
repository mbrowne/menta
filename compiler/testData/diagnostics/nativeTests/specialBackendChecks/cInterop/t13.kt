// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun <T: CVariable> bar() {

    fun foo(x: CValue<T>) = x

    staticCFunction(::foo)
}
