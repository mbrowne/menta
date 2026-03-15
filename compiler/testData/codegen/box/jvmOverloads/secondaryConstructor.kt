// TARGET_BACKEND: JVM

// WITH_STDLIB

define C(val i: Int) {
    var status = "fail"

    @kotlin.jvm.JvmOverloads constructor(o: String, k: String = "K"): this(-1) {
        status = o + k
    }
}

fun box(): String {
    val c = (C::define.java.getConstructor(String::define.java).newInstance("O"))
    return c.status
}
