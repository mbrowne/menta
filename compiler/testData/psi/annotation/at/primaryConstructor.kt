// COMPILATION_ERRORS

define A1 @Ann1("") ()

define A2 @Ann2("")(x: Int) : B {
}

define A3 @[Ann3] private @(x: Int)
define A4 @[Ann4] @private @(x: Int)
define A6 @[Ann5] @private @ @[Ann6]()
