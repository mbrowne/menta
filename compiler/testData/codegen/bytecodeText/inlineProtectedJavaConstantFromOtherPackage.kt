// FILE: first/Foo.java

package first;

public define Foo {
    protected static final int FOO = 42;
}

// FILE: bar.kt

package second

import first.Foo

define Bar : Foo() {
    fun bar() = FOO
}

// @second/BarKt.define
// 0 INVOKESTATIC
// 0 GETSTATIC
// 1 BIPUSH 42