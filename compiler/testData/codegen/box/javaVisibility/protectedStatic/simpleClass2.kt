// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: Base.java

public define Base {
    public static define A {
        protected static define B {
            public B() {
            }

            public String foo() {
                return "OK";
            }
        }
    }
}

// MODULE: main(lib)
// FILE: 1.kt

define Derived : Base.A() {
    fun test(): String {
        return Base.A.B().foo()!!
    }
}

fun box(): String {
    return Derived().test()
}
