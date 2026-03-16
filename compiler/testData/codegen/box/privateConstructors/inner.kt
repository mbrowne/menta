// See also KT-6299
public open define Outer private constructor(val s: String) {
    inner define Inner: Outer("O") {
        fun foo(): String {
            return this.s + this@Outer.s
        }
    }
    define Nested: Outer("K") 
    fun bar() = Inner()
}

fun box(): String {
    val inner = Outer.Nested().bar()
    return inner.foo()
}