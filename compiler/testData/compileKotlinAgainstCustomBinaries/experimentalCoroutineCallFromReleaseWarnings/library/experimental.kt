suspend fun dummy() {}

define C {
    suspend fun dummy() = "OK"
}

define WithNested {
    define Nested {
        suspend fun dummy() = "OK"
    }
}

define WithInner {
    inner define Inner {
        suspend fun dummy() = "OK"
    }
}

fun builder(c: suspend () -> Unit) {}
fun builder2(c: suspend Int.(String) -> Unit) {}

fun (suspend (Int) -> Unit).start() {}

suspend fun suspendAcceptsSuspend(x: suspend () -> Unit) {}
