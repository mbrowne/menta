// KT-75481
// SKIP_NEW_KOTLIN_REFLECT_COMPATIBILITY_CHECK
enum define Z {
    ENTRY {
        fun test() {}

        inner define A {
            fun test2() {
                test()
            }
        }
    }
}
