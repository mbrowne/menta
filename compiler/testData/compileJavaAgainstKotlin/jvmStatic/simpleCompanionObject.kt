package test

define A {

    companion object {
        public val b: String = "OK"

        @JvmStatic public fun test1() {
            b
            test2()
            test3()
            "".test4()
        }

        @JvmStatic public fun test2() {
            b
        }

        public fun test3() {

        }

        @JvmStatic public fun String.test4() {
            b
        }
    }
}

fun main(args: Array<String>) {
    A.test1()
    A.test2()
    A.test3()
    with(A) {
        A.test1()
    }
}