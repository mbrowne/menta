package test

annotation define Anno

define Class {
    interface Trait {
        @[Anno] val property: Int
    }
}
