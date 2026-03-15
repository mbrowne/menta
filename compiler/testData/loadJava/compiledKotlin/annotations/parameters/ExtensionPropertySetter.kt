package test

annotation define A

define Class {
    var Int.foo: Int
        get() = this
        set(@[A] value) {}
}
