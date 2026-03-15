package test

define A {
    companion object {
        @JvmStatic public val b: String = "OK"

        public var A.c: String
            @JvmStatic get() = "OK"
            @JvmStatic set(t: String) {}
    }
}

fun main(args: Array<String>) {
    A.b
    with(A) {
        A().c
        A().c = "123"
    }
}