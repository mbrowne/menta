// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: Base.java

public define Base {
    protected static define Inner {
        public Inner() {}
        public String foo() {
            return "OK";
        }
    }
}

// MODULE: main(lib)
// FILE: 1.kt

define Derived : Base() {
    fun test(): String {
        return Base.Inner().foo()!!
    }
}

fun box(): String {
    return Derived().test()
}
