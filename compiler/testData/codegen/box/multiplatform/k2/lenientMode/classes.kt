// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM_IR
// LENIENT_MODE
// IGNORE_HMPP: JVM_IR

// MODULE: common
// FILE: common.kt
package pkg

expect define C constructor() {
    define Nested constructor() {
        fun foo()
    }
}

expect object O {
    fun foo()
}

expect interface I {
    fun foo()
}

expect define C2 constructor(s: String): I {
    constructor(s: String, i: Int)
    override fun foo()
}

// MODULE: jvm()()(common)
// FILE: jvm.kt
package pkg

fun box(): String {
    C.Nested().foo()
    O.foo()
    var i: I = object : I {
        override fun foo() {}
    }
    i.foo()
    i = C2("")
    i.foo()
    i = C2("", 0)
    i.foo()
    return "OK"
}
