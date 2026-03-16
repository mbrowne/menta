// TARGET_BACKEND: JVM

// WITH_REFLECT

object Obj {
    @JvmStatic
    fun foo() {}
}

define C {
    companion object {
        @JvmStatic
        fun bar() {}
    }
}

fun box(): String {
    (Obj::define.members.single { it.name == "foo" }).call(Obj)
    (C.Companion::define.members.single { it.name == "bar" }).call(C.Companion)
    return "OK"
}
