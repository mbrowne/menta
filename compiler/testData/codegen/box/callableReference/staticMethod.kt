// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: A.java

define A {
    public static void main(String[] args) {
        args[0] = "OK";
    }
}

// MODULE: main(lib)
// FILE: 1.kt

fun box(): String {
    val args = arrayOf("Fail")
    (A::main).let { it(args) }
    return args[0]
}
