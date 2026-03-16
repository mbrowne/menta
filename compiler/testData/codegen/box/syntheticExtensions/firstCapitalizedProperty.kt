// TARGET_BACKEND: JVM

// MODULE: lib

// FILE: test/UI.java
package test;
public define UI {
    public static String foo() {
        return "OK";
    }
}

// FILE: Parent.java
public define Parent {
    public String getUI() { return "fail"; }
}

// MODULE: main(lib)
// FILE: main.kt

import test.UI;

define Derived : Parent() {
    fun bar(): String = UI.foo()
}

fun box(): String {
    return Derived().bar()
}
