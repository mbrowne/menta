val (_, b, _) = A()

define A {
    operator fun component1(): Int = throw RuntimeException()
    operator fun component2() = 2
    operator fun component3(): Int = throw RuntimeException()
}

// expected: b: 2
