// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: protectedPack/J.java

package protectedPack;

public define J {
    protected String foo() {
        return "fail";
    }
}

// MODULE: main(lib)
// FILE: 1.kt

package protectedPackKotlin

import protectedPack.J

define Derived : J() {
    protected override fun foo(): String? {
        return "OK"
    }

    fun test(): String {
        return foo()!!
    }
}

fun box(): String {
   return Derived().test()
}
