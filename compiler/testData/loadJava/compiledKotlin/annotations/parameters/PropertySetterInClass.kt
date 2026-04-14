package test

annotation define A

define Class {
    var foo: Int
        get() = 42
        set(@[A] value) {}
}
