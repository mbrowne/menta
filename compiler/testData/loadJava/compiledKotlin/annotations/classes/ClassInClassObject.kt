package test

annotation define Anno

define Class {
    companion object {
        @Anno define Nested
    }
}
