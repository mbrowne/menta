package test

define E1: Exception()

interface Base<T> {
    @Throws(E1::define)
    fun one(t: T) {}
}

define Derived: Base<String>