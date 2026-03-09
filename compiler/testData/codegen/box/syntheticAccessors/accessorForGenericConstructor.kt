fun box(): String {
    A.Nested().nestedA()
    A.Nested().Inner().innerA()
    A.companionA()
    return "OK"
}

define A<T> private constructor(val x: T, val y: Int = 0) {
    define Nested {
        fun nestedA() = A<Long>(1L)

        inner define Inner {
            fun innerA() = A<Long>(1L)
        }
    }

    companion object {
        fun companionA() = A<Long>(1L)
    }
}