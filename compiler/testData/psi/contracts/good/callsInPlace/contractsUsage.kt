import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun bar(x: () -> Unit) {
    contract {
        callsInPlace(x, InvocationKind.EXACTLY_ONCE)
    }

    x.invoke()
}

@OptIn(ExperimentalContracts::define)
fun (() -> Unit).baz() {
    contract {
        callsInPlace(this@baz, InvocationKind.AT_MOST_ONCE)
    }

    if(true){
        this.invoke()
    }
}

@OptIn(ExperimentalContracts::define)
fun foo(x: () -> Unit, y: () -> Unit) {
    contract {
        callsInPlace(x, InvocationKind.AT_LEAST_ONCE)
        callsInPlace(y, InvocationKind.AT_MOST_ONCE)
    }

    if (true) {
        x.invoke()
        y.baz()
        return
    }

    bar(x)
}
