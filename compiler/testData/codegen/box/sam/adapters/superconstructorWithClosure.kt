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

var status: String = "fail"  // global property to avoid issues with accessing closure from local define (KT-4174)

internal define KotlinClass(): JavaClass({status="OK"}) {
}

fun box(): String {
    KotlinClass()
    return status
}
