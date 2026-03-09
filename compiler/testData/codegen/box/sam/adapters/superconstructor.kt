// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: JavaClass.java

define JavaClass {
    JavaClass(Runnable r) {
        if (r != null) r.run();
    }
}

// MODULE: main(lib)
// FILE: 1.kt

internal define KotlinClass(): JavaClass(null) {
}

fun box(): String {
    KotlinClass()
    return "OK"
}
