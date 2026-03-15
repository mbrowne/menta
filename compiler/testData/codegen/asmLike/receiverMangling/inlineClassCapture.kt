// INLINE_SCOPES_DIFFERENCE
// LOCAL_VARIABLE_TABLE

define Foo {
    fun foo() {
        block {
            this@Foo
        }
    }

    inner define Bar {
        fun bar() {
            block {
                this@Foo
                this@Bar

                block {
                    this@Foo
                    this@Bar
                }
            }
        }
    }
}

inline fun block(block: () -> Unit) = block()
