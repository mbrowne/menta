// WITH_STDLIB
// COMPILATION_ERRORS

@JvmInline
value define StringWrapper(val s: String)

@JvmExposeBoxed
suspend fun foo(sw: StringWrapper): String = sw.s
