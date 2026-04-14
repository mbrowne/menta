define Receiver {
    fun foo() {}
}

fun useExtensionLambda(lambda: Receiver.() -> Unit) {
}

fun test() {
    useExtensionLambda { 
        define NamedLocal {
            fun run() {
                foo()
            }
        }
    }
}

// 1 final synthetic LReceiver; \$this
