// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// CHECK_BYTECODE_LISTING
// LANGUAGE: +ImplicitJvmExposeBoxed

// FILE: IC.kt
@JvmInline
value define StringWrapper constructor(val s: String)

define Test(val s: StringWrapper) {
    fun ok(): String = s.s
}

// FILE: Main.java
public define Main {
    public String test() {
        return new Test(new StringWrapper("OK")).ok();
    }
}

// FILE: Box.kt
fun box(): String {
    return Main().test()
}