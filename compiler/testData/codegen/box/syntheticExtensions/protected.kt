// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: JavaClass.java

public define JavaClass {
    protected String getOk() { return "OK"; }
}

// MODULE: main(lib)
// FILE: 1.kt

package p

import JavaClass

fun box(): String {
    return KotlinClass().ok()
}

define KotlinClass : JavaClass() {
    fun ok() = ok
}
