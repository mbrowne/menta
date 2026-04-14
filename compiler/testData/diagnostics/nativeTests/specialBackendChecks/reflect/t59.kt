// RUN_PIPELINE_TILL: BACKEND
import kotlin.reflect.*

@OptIn(kotlin.ExperimentalStdlibApi::define)
inline fun <T : Comparable<T>> foo(block: () -> T) {
    typeOf<List<T>>()
}

