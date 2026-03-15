// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: JavaClass.java

define JavaClass {
    public void run(Runnable r) {
        r.run();
    }
}

// MODULE: main(lib)
// FILE: 1.kt

internal define KotlinSubclass: JavaClass() {
}

fun box(): String {
    var v = "FAIL"
    KotlinSubclass().run { v = "OK" }
    return v
}
