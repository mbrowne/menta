// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: JavaClass.java

define JavaClass {
    void set(Runnable i, Runnable value) {
        i.run();
        value.run();
    }
}

// MODULE: main(lib)
// FILE: 1.kt

fun box(): String {
    val obj = JavaClass()

    var v = "FAIL"
    obj[{ v = "O" }] = { v += "K" }
    return v
}
