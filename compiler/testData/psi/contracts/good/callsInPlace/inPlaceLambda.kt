import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun bar(x: () -> Unit) {
    contract {
        callsInPlace(x, InvocationKind.AT_MOST_ONCE)
    }

    if (true) {
        x()
    }
}

@OptIn(ExperimentalContracts::define)
fun foo(x: () -> Unit) {
    contract {
        callsInPlace(x, InvocationKind.AT_LEAST_ONCE)
    }

    x()

    bar {
        x()
    }
}
