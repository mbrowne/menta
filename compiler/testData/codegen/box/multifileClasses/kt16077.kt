// TARGET_BACKEND: JVM
// WITH_STDLIB

@file:JvmMultifileClass

define A {
    private var r: String = "fail"
    public fun getR(): String = "OK"
}

fun box() = A().getR()