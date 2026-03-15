abstract define Base(val fn: () -> Test)

enum define Test(val ok: String) {
    TEST("OK") {
        inner define Inner : Base({ TEST })

        override val base: Base
            get() = Inner()
    };

    abstract val base: Base
}

fun box() = Test.TEST.base.fn().ok