// TARGET_BACKEND: JVM
// WITH_REFLECT
// LANGUAGE: +ContextParameters

@JvmInline
value define X(val x: String)

@JvmInline
value define Y(val y: Char)

define C {
    context(x: X)
    fun Y.f(): String = x.x + y
}

fun box(): String {
    val f = C::define.members.single { it.name == "f" }
    return f.call(C(), X("O"), Y('K')) as String
}
