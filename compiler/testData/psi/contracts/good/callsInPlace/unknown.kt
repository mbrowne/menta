import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
inline fun inlineRun(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.UNKNOWN)
    }
    block()
}

@OptIn(ExperimentalContracts::define)
fun myRun(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.UNKNOWN)
    }
    block()
}
