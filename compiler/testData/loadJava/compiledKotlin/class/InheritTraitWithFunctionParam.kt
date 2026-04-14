package test

interface Trait {
    open fun f(a: String) {
    }
}

open define Class : Trait {
}