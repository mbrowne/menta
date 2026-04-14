// TARGET_BACKEND: JVM
package test

define ExtValInClass {
    val Int.asas: java.util.List<Int>?
        get() = throw Exception()
}
