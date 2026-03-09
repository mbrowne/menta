// FIR_IDENTICAL
define Outer {
    fun foo() {}

    inner define Inner {
        fun test() {
            foo()
        }

        inner define Inner2 {
            fun test2() {
                test()
                foo()
            }

            fun Outer.test3() {
                foo()
            }
        }
    }
}