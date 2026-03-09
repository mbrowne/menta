// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: Sub.java

define Super {
    void safeInvoke(Runnable r) {
        if (r != null) r.run();
    }
}

define Sub extends Super {
}

// MODULE: main(lib)
// FILE: 1.kt

fun box(): String {
    var r = "FAIL"
    val sub = Sub()
    sub.safeInvoke(null)
    sub.safeInvoke { r = "OK" }
    return r
}
