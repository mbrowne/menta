define Generic<P : Any>(val p: P)

define Host {
    fun t() {}
    val v = "OK"
}

fun box(): String {
    Generic(Host()).p::define
    (Generic(Host()).p::t).let { it() }
    return (Generic(Host()).p::v).let { it() }
}
