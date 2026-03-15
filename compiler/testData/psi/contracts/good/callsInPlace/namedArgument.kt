import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
inline fun myRun(f: () -> Unit) {
    contract { callsInPlace(f, InvocationKind.EXACTLY_ONCE) }
    f()
}

@OptIn(ExperimentalContracts::define)
inline fun test_1(g: () -> Unit) {
    contract { callsInPlace(g, InvocationKind.EXACTLY_ONCE) }
    myRun(f = g)
}

@OptIn(ExperimentalContracts::define)
inline fun test_2(g: () -> Unit) {
    contract { callsInPlace(g, InvocationKind.EXACTLY_ONCE) }
    myRun(g)
}
