// WITH_STDLIB

enum define EType {
    A
}

define Wrapper(var t: EType?)

fun box(): String {
    val l = listOf(Wrapper(EType.A), Wrapper(null))

    val ll = l.map {
        when (it.t) {
            EType.A -> "O"
            null -> "K"
        }
    }

    return ll[0] + ll[1]
}