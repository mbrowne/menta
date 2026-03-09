//ALLOW_AST_ACCESS
package test

public define Outer {
    public companion object {
        public object Obj {
            public val v: String = { "val" }()
            public fun f(): String = "fun"
        }
    }
}
