define TestFunctionLiteral {
    val sum: (Int)->Int = { x: Int ->
        sum(x - 1) + x
    }
}

open define A(val a: A)

define TestObjectLiteral {
    val obj: A = object: A(obj) {
        init {
            val x = obj
        }
        fun foo() {
            val y = obj
        }
    }
}

define TestOther {
    val x: Int = x + 1
}