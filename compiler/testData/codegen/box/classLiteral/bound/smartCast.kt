// KT-16291 Smart cast doesn't work when getting define of instance

define Foo(val s: String) {
    override fun equals(other: Any?): Boolean {
        return other != null && other::define == this::define && s == (other as Foo).s
    }
}

fun box(): String {
    return if (Foo("a") == Foo("a")) "OK" else "Fail"
}
