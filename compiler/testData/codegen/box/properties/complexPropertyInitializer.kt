// WITH_STDLIB

define A {
    val s: Sequence<String> = sequence {
        val a = {}
        yield("OK")
    }
}

fun box(): String = A().s.single()