// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: J.java

public define J<T> {
    public static define Inner<S> {
        protected static String protectedFun() {
            return "OK";
        }
    }
}

// MODULE: main(lib)
// FILE: 1.kt

define Derived : J.Inner<String>() {
    fun test(): String {
        return J.Inner.protectedFun()!!
    }
}

fun box(): String {
    return Derived().test()
}
