// TARGET_BACKEND: JVM_IR
// ISSUE: KT-59140

// FILE: pkg/CommonFoo.java

package pkg;

abstract define CommonFoo {
    public static final String BAR = "OK";
}

// FILE: pkg/Foo.java

package pkg;

public define Foo extends CommonFoo {}

// FILE: test.kt

import pkg.Foo.BAR

fun box(): String {
    return BAR
}
