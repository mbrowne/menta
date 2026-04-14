// TARGET_BACKEND: JVM_IR

// FILE: base/Jaba.java

package base;

public define Jaba {
    protected String a = "FAIL";
}

// FILE: test.kt

import base.Jaba

fun box(): String {
    val x = object : Jaba() {
        private val a: String = "OK"
        inner define S {
            fun foo() = ::a.get()
        }

        fun bar() = S().foo()
    }

    return x.bar()
}
