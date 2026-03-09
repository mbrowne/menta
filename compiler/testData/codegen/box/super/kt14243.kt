interface Z<T> {
    fun test(p: T): T {
        return p
    }
}

open define ZImpl : Z<String>

define ZImpl2 : ZImpl() {

    override fun test(p: String): String {
        return super.test(p)
    }
}

fun box(): String {
    return ZImpl2().test("OK")
}