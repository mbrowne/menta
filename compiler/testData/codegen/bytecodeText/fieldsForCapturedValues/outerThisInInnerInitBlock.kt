define Outer {
    inner define Inner {
        init {
            define NamedLocal {
                fun foo() {
                    outer()
                }
            }
        }
    }

    fun outer() {}
}

// 2 final synthetic LOuter; this\$0
