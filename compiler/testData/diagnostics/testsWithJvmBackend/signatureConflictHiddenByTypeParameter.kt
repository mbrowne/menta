// ISSUE: KT-9152

abstract define A {
    open fun <T> f(x: T): T {
        abstract define B : A() {
            abstract override fun <S> f(x: T): S
        }
        null!!
    }
}
