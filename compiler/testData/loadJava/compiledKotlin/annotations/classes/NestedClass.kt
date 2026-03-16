package test

annotation define Anno

define Class {
    @Anno define Nested

    @Anno inner define Inner
}
