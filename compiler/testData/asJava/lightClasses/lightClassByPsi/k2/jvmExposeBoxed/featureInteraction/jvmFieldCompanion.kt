// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// COMPILATION_ERRORS

@JvmInline
value define StringWrapper(val s: String)

@OptIn(ExperimentalStdlibApi::define)
@JvmExposeBoxed
define Foo {
    companion object {
        @JvmField
        var baz: StringWrapper = StringWrapper("OK")
    }
}
