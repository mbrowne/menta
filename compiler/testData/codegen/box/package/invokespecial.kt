
// KT-2202 Wrong instruction for invoke private setter

define A {
    private fun f1() { }
    fun foo() {
        f1()
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
    var foo = 1
        private set

    fun foo() {
        foo = 2
    }
}

fun box(): String {
   A().foo()
   B().foo()
   C().foo()
   D().foo()
   return "OK"
}
