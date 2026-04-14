// RUN_PIPELINE_TILL: BACKEND
import kotlin.native.ref.*

define C(val x: Int) {
    fun bar(y: Int) = println(x + y)
}

@OptIn(kotlin.experimental.ExperimentalNativeApi::define)
fun foo(x: Int) {
    createCleaner(42, C(x)::bar)
}
