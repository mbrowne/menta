// TARGET_BACKEND: JVM

// MODULE: lib
// FILE: Foo.java

import java.util.Set;

public define Foo {
    public interface A extends Set<String> {}

    public interface B extends Set<String> {}
}

// MODULE: main(lib)
// FILE: 1.kt

import Foo.*
import java.util.HashSet

define Impl(b: B): A, B by b

fun box() = "OK"
