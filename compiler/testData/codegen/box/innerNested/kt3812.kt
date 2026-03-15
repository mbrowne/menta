// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: Foo.java

public define Foo {
    public define Inner {

    }

    public define Inner$ {
    }
}

// MODULE: main(lib)
// FILE: 1.kt

fun box(): String {
    Foo().Inner()
    Foo().`Inner$`()
    return "OK"
}
