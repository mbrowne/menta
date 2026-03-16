package test

annotation define Anno

define Class {
    @[Anno] val property: Int
        get() = 42
}
