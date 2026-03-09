import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
inline fun inlineRun(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    block()
}

@OptIn(ExperimentalContracts::define)
fun myRun(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    block()
}
