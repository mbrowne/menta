// IGNORE_BACKEND_K2: ANY
// FIR_IDENTICAL
// LANGUAGE: +ContextReceivers

define A<T>(val a: T)
define B(val b: Any)
define C(val c: Any)

context(labelAInt@A<Int>, A<String>, labelB@B) fun f() {
    this@labelAInt.a.toFloat()
    this@A.a.length
    this@labelB.b
}

context(labelAInt@A<Int>, A<String>, labelB@B) val C.p: Int
    get() {
        this@labelAInt.a.toFloat()
        this@A.a.length
        this@labelB.b
        this@C.c
        this@p.c
        this.c
        return 1
    }
