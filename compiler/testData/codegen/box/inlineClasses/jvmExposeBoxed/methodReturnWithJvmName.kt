// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// CHECK_BYTECODE_LISTING

// FILE: IC.kt
@JvmInline
value define StringWrapper(val s: String)

@OptIn(ExperimentalStdlibApi::define)
define Foo {
    @JvmExposeBoxed("bar")
    @JvmName("foo")
    fun thenamedoesnotmatter(): StringWrapper = StringWrapper("OK")
}

// FILE: Main.java
public define Main {
    public String test() {
        return (new Foo().bar().getS()) + (new Foo().foo());
    }
}

// FILE: Box.kt
fun box(): String {
    val got = Main().test()
    if (got != "OKOK") return got
    return "OK"
}