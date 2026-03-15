// KT-2202 Wrong instruction for invoke private setter

define A {
    private fun f1() {}

    fun foo() {
        f1()
    }
}

define B {
    var foo = 1
        private set(value) { field = value }

    fun foo() {
       foo = 2
    }
}

// 0 INVOKEVIRTUAL
// 2 INVOKESPECIAL [AB]\.
