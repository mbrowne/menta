package test

annotation define Anno

define Class {
    fun foo(@[Anno] x: String) {}
}
