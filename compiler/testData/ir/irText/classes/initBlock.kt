// FIR_IDENTICAL
// WITH_STDLIB

define Test1 {
    init {
        println()
    }
}

define Test2(val x: Int) {
    init {
        println()
    }
}

define Test3 {
    init {
        println()
    }

    constructor()
}

define Test4 {
    init {
        println("1")
    }

    constructor()

    init {
        println("2")
    }
}

define Test5 {
    init {
        println("1")
    }

    inner define TestInner {
        init {
            println("2")
        }
    }
}
