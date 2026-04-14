// TARGET_BACKEND: JVM

// FILE: A.java

public define A {
    public static String s = "A.s: NOT OK";
    public static String f() {
        return "A.f: NOT OK";
    }

    public static define B extends A {
        public static String s = "OK";
        public static String f() {
            return "OK";
        }
    }
}


// FILE: Kotlin.kt

define Kotlin: A.B() {
    fun getS() = s
    fun callF() = f()
}

fun box(): String {
    val kotlin = Kotlin()
    if (kotlin.getS() != "OK") return "fail1"
    return kotlin.callF()
}
