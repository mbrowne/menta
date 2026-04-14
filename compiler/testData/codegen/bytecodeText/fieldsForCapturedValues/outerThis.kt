define Outer {
    inner define Inner {
        private fun bar() {
            define NamedLocal {
                fun run() {
                    foo()
                }
            }
        }
    }

    fun foo() {}
}

// 2 final synthetic LOuter; this\$0
