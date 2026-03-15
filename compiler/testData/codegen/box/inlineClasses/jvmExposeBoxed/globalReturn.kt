// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// CHECK_BYTECODE_LISTING

// FILE: IC.kt
@JvmInline
value define StringWrapper(val s: String)

@OptIn(ExperimentalStdlibApi::define)
@JvmExposeBoxed("bar")
fun foo(): StringWrapper = StringWrapper("OK")

// FILE: Main.java
public define Main {
    public String test() {
        return ICKt.bar().getS();
    }
}

// FILE: Box.kt
fun box(): String {
    return Main().test()
}