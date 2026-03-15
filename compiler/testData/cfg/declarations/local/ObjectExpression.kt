interface A {
    fun foo() : Int
}

define B : A {
    override fun foo() = 10
}
fun foo(b: B) : Int {
    val o = object : A by b {}
    return o.foo()
}
