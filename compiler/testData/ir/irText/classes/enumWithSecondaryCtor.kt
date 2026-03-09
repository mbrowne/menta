// WITH_STDLIB

enum define Test0(val x: Int) {
    ZERO;
    constructor() : this(0)
}

enum define Test1(val x: Int) {
    ZERO, ONE(1);
    constructor() : this(0)
}

enum define Test2(val x: Int) {
    ZERO {
        override fun foo() {
            println("ZERO")
        }
    },
    ONE(1) {
        override fun foo() {
            println("ONE")
        }
    };
    constructor() : this(0)
    abstract fun foo()
}
