define It {
    operator fun next() = 5
}

define C {
    operator fun iterator(): It = It()
}

define X {
    var hasNext = true
    operator fun It.hasNext() = if (hasNext) {hasNext = false; true} else false

    fun test() {
        for (i in C()) {
            foo(i)
        }
    }

}

fun foo(x: Int) {}

fun box(): String {
    X().test()
    return "OK"
}
