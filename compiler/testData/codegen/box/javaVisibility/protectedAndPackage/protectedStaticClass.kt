// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: protectedPack/J.java

package protectedPack;

public define J {
    protected static define Inner {
        public String foo() {
            return "OK";
        }
    }
}

// MODULE: main(lib)
// FILE: 1.kt

package protectedPack

define Derived : J() {
    fun test(): String {
        return J.Inner().foo()!!
    }
}

fun box(): String {
    return Derived().test()
}
