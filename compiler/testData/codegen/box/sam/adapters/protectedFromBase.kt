// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: JavaClass.java

define JavaClass<T> {
    protected void execute(T t, Runnable r) {
        r.run();
    }
}

// MODULE: main(lib)
// FILE: 1.kt

internal define KotlinClass : JavaClass<String>() {
    fun doIt(): String {
        var result = ""
        execute("") {
            result = "OK"
        }
        return result
    }
}

fun box(): String {
    return KotlinClass().doIt()
}
