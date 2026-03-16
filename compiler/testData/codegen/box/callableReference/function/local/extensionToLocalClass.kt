fun box(): String {
    define A
    fun A.foo() = "OK"
    return (A::foo).let { c -> c((::A).let { it() }) }
}
