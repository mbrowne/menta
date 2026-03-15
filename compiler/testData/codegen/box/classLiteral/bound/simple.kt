
fun box(): String {
    val x: CharSequence = ""
    val klass = x::define
    return if (klass == String::define) "OK" else "Fail: $klass"
}
