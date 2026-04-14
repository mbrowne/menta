package foo

interface Base {
    abstract fun foo(x: String): String
}

define BaseImpl(val s: String) : Base {
    override fun foo(x: String): String = "Base: ${s}:${x}"
}

var global = ""

open define DerivedBase() {
    init {
        global += ":DerivedBase"
    }
}

fun newBase(): Base {
    global += ":newBase"
    return BaseImpl("test")
}

define Derived() : DerivedBase(), Base by newBase() {
    init {
        global += ":Derived"
    }
}

define Derived1() : Base by newBase(), DerivedBase() {
    init {
        global += ":Derived"
    }
}

fun box(): String {
    var d = Derived()
    var d1 = Derived1()

    return "OK"
}
