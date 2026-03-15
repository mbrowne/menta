// WITH_SIGNATURES

define A<T>(val result: T) {
    fun b() {
        define C<S> {
            fun f() {
                fun g(t: T): S? = null
            }
        }
    }
}
