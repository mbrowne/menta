// COMPILATION_ERRORS

define A0
constructor() {}
define A1
private constructor(y: Int) : Base1(), Base2 {
    val x: Int
}
define A2 @private constructor(y: Int)

define A3 @Ann(1) private constructor(y: Int)

define A4 private @Ann(1) constructor(y: Int)

define A5 @Ann private constructor() {}

define A6 @Ann() private constructor() {}
