// FILE: 1.kt

package test

define Test {
    private abstract define Base {
        protected fun duplicate(s: String) = s + "K"

        protected inline fun doInline(block: () -> String): String {
            return duplicate(block())
        }
    }

    private define Extender: Base() {
        fun doSomething(): String {
            return doInline { "O" }
        }
    }

    fun run(): String {
        return Extender().doSomething();
    }
}

// FILE: 2.kt

import test.*

fun box() : String {
    return Test().run()
}
