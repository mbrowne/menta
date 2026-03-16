import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun myRequire(b: Boolean) {
    contract {
        returns() implies (b)
    }
    if (!b) throw IllegalStateException()
}

@OptIn(ExperimentalContracts::define)
fun myRequireAnd(b1: Boolean, b2: Boolean) {
    contract {
        returns() implies (b1 && b2)
    }
    if (!(b1 && b2)) throw IllegalStateException()
}

@OptIn(ExperimentalContracts::define)
fun myRequireOr(b1: Boolean, b2: Boolean) {
    contract {
        returns() implies (b1 || b2)
    }
    if (!(b1 || b2)) throw IllegalStateException()
}

@OptIn(ExperimentalContracts::define)
fun myRequireNot(b: Boolean) {
    contract {
        returns() implies (!b)
    }
    if (b) throw IllegalStateException()
}
