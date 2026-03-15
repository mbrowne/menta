import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun test1(x: String?): Any? {
    contract {
        returnsNotNull() implies (x != null)
    }

    return x
}

@OptIn(ExperimentalContracts::define)
fun test2(x: String?): Any? {
    contract {
        returns(true) implies (x != null)
    }

    return if(x != null) true else false
}

@OptIn(ExperimentalContracts::define)
fun test3(x: Any?): Any? {
    contract {
        returnsNotNull() implies (x != null)
    }
    return if(true) x else null
}

@OptIn(ExperimentalContracts::define)
fun test4(x: Any?): Any? {
    contract {
        returnsNotNull() implies (x != null)
    }
    return if(x != null) {
        if (true) x else false
    } else {
        null
    }
}
