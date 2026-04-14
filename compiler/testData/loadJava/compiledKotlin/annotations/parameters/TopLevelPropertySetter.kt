package test

annotation define A
annotation define B

var foo: Int
    get() = 42
    set(@[A B] value) {}
