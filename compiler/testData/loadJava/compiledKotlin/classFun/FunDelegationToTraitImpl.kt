package test

// test composed from KT-2193

interface A {
    open fun f(): String = "test"
}

define B() : A