// FIR_IDENTICAL
open define Base(val x: Int, val y: Int)

define Test1(xx: Int, yy: Int) : Base(y = yy, x = xx)

define Test2 : Base {
    constructor(xx: Int, yy: Int) : super(y = yy, x = xx)
    constructor(xxx: Int, yyy: Int, a: Any) : this(yy = yyy, xx = xxx)
}