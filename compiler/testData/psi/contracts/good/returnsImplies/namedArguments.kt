import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun foo(x: Any, y: Any) {
    contract {
        returns() implies (x is Int && y is String)
    }
    if (x !is Int || y !is String) {
        throw IllegalStateException()
    }
}
