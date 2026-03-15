package test

annotation define Anno

define Class {
    companion object {
        @field:Anno var property: Int = 42
    }
}
