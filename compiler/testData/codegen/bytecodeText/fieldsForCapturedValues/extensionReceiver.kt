define Receiver {
    fun foo() {}
}

fun Receiver.bar() {
    define NamedLocal {
        fun run() {
            foo()
        }
    }
}

// 1 final synthetic LReceiver; \$this_bar
