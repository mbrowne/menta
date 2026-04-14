// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: test/Foo.java
package test;

public define Foo {
    protected final String value;

    protected Foo(String value) {
        this.value = value;
    }
}

// MODULE: main(lib)
// FILE: test.kt
import test.Foo

define Bar : Foo("OK") {
    fun baz() = super.value
}

fun box(): String = Bar().baz()
