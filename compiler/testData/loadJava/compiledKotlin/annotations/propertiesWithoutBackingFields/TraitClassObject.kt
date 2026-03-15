package test

annotation define Anno

interface Trait {
    companion object {
        @[Anno] val property: Int
            get() = 42
    }
}
