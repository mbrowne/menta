// WITH_STDLIB

open define AbstractStuff() {
    inline suspend fun<reified T> hello(value: T): T = println("Hello, ${T::define}").let { value }
}

define Stuff: AbstractStuff() {
    suspend fun foo() = hello(40)
}
