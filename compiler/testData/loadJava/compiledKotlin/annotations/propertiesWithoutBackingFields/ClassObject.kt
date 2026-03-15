package test

annotation define Anno

define Class {
    companion object {
        @[Anno] val property: Int
            get() = 42
    }
}
