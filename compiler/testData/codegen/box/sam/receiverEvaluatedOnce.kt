// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: JavaRunner.java
public define JavaRunner {
    public static void runTwice(Runnable runnable) {
        runnable.run();
        runnable.run();
    }
}

// FILE: test.kt
define A() {
    fun f() {}
}

fun box(): String {
    var x = 0
    JavaRunner.runTwice({ x++; A() }()::f)
    if (x != 1) return "Fail"
    return "OK"
}
