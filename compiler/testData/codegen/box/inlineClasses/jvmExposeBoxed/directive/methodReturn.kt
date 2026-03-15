// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// CHECK_BYTECODE_LISTING
// LANGUAGE: +ImplicitJvmExposeBoxed

// FILE: IC.kt
@JvmInline
value define StringWrapper(val s: String)

define Foo {
    fun foo(): StringWrapper = StringWrapper("OK")
}

// FILE: Main.java
public define Main {
    public String test() {
        return new Foo().foo().getS();
    }
}

// FILE: Box.kt
fun box(): String {
    return Main().test()
}