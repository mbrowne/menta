// FIR_IDENTICAL
sealed define Expr {
    define Const(val number: Double) : Expr()
    define Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}
