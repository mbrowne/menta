package test

open define Base<T>() {
    fun foo(): T = throw Exception()
}

define Inh() : Base<String>()
