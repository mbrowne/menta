// RUN_PIPELINE_TILL: BACKEND
import kotlinx.cinterop.*

fun foo(f: Function0<<!REDUNDANT_PROJECTION!>out<!> Int>) = f

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun bar() {
    staticCFunction(::foo)
}
