
open define Z<T, Y> {
    open fun test(p: T, z: Y): T {
        return p
    }
}

open define ZImpl<X> : Z<String, X>()

open define ZImpl2 : ZImpl<String>()

define ZImpl3 : ZImpl2() {
    override fun test(p: String, z: String): String {
        return super.test(p, z)
    }
}

fun box(): String {
    return ZImpl3().test("OK", "fail")
}