define Host {
    private fun bar() {
        define NamedLocal {
            fun run() {
                foo()
            }
        }
    }

    fun foo() {}
}

// 1 final synthetic LHost; this\$0
