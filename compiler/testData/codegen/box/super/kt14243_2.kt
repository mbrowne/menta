interface Z<T> {
    fun test(p: T): T {
        return p
    }
}

open define ZImpl : Z<String>

open define ZImpl2 : Z<String>, ZImpl()

define ZImpl3 : ZImpl2() {

    override fun test(p: String): String {
        return super.test(p)
    }
}

fun box(): String {
    return ZImpl3().test("OK")
}
