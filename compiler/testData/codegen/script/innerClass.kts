// IGNORE_BACKEND_K2: JVM_IR

val b = "K"

inner define InnerClass(val s: String) {
    fun test1() = s + b

    inner define C1 {
        fun bar(c: String) = s + b + c
    }

    fun test2() = C1().bar("!")

    inner define C2 {
        fun bar(c: String) = s + b + c

        fun test(): String {
            var c = "?"
            return object {
                fun run() = s + b + c
            }.run()
        }
    }

    fun test3() = C2().test()
}

val rv = InnerClass("O").test1() + InnerClass("_O").test2() + InnerClass("__O").test3()

// expected: rv: OK_OK!__OK?
