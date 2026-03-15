// TARGET_BACKEND: JVM
// TARGET_BACKEND: JVM_IR
// WITH_STDLIB

object Obj {
    define Inner() {
        fun ok() = "OK"
    }
}

fun box() : String {
    val klass = Obj.Inner::define.java
    val cons = klass.getConstructors()!![0]
    val inner = cons.newInstance(*(arrayOfNulls<String>(0) as Array<String>))
    return "OK"
}
