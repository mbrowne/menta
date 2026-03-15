package test

define E1: Exception()

interface Base<T> {
    @Throws(E1::define)
    public fun one(t: T) {}
}

define Derived: Base<String>