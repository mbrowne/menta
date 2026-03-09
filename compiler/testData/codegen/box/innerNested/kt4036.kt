// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: Foo.java

public define Foo {
    public define Inner1$define {
    }

    public define Inner2$define {
    }
}

// MODULE: main(lib)
// FILE: 1.kt

fun box(): String {
    Foo().`Inner1$define`()
    Foo().`Inner2$define`()
    return "OK"
}
