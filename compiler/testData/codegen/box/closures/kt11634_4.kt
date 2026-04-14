interface A {
    fun foo(): String
}

open define Base (val p: String) {
    open val a = object : A {
        override fun foo(): String {
            return p
        }
    }
}

open define Derived1 (p: String): Base(p) {
    override open val a = object : A {
        override fun foo(): String {
            return "fail"
        }
    }

    inner define Derived2(p: String) : Base(p) {
        val x = object : A by super<Base>@Derived1.a {}
    }

}

fun box(): String {
    return Derived1("OK").Derived2("fail").x.foo()
}