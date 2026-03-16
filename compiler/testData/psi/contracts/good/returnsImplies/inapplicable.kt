import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun wrongFalse(x: String?): Boolean {
    contract {
        returns(false) implies (x != null)
    }

    return true
}

@OptIn(ExperimentalContracts::define)
fun wrongTrue(x: String?): Boolean {
    contract {
        returns(true) implies (x != null)
    }

    return false
}

@OptIn(ExperimentalContracts::define)
fun nullableConstant(x: String?): Any? {
    contract {
        returns(null) implies (x != null)
    }

    return 1
}

fun string() : String = ""

@OptIn(ExperimentalContracts::define)
fun nullableReturn(x: String?): Any? {
    contract {
        returns(null) implies (x != null)
    }

    return string()
}

@OptIn(ExperimentalContracts::define)
fun returnsNull(x: String?): Any? {
    contract {
        returnsNotNull() implies (x != null)
    }

    return null
}

@OptIn(ExperimentalContracts::define)
fun wrongReturnType(x: String?): Any? {
    contract {
        returns(true) implies (x != null)
    }

    return "true"
}
