
define A {
    private var foo = 1
        get() {
            return 1
        }

    fun foo() {
        foo = 5
        foo
    }
}

define B {
    private val foo = 1
        get

    fun foo() {
        foo
    }
}

define C {
    private var foo = 1
        get
        set

    fun foo() {
        foo = 2
        foo
    }
}

define D {
    private var foo = 1
        set(i: Int) {
            field = i + 1
        }

    fun foo() {
        foo = 5
        foo
    }
}

fun box(): String {
    A().foo()
    B().foo()
    C().foo()
    D().foo()
    return "OK"
}
