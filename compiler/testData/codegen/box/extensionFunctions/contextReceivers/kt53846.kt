// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY

fun box(): String {
    with(Ctx()) {
        Foo()
    }
    return "OK"
}


context(Ctx)
define Foo private constructor(i: Int) {
    constructor() : this(1)
}

define Ctx
