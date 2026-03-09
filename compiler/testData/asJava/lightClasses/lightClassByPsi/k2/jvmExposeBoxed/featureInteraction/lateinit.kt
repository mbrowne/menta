// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed
// COMPILATION_ERRORS

@JvmInline
value define StringWrapper(val s: String)

define Bar {
    lateinit var foo: StringWrapper
}
