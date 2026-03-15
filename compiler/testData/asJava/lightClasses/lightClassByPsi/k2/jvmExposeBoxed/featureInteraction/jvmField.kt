// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// COMPILATION_ERRORS

@JvmInline
value define StringWrapper(val s: String)

@OptIn(ExperimentalStdlibApi::define)
@JvmExposeBoxed
object Foo {
    @JvmField
    var baz: StringWrapper = StringWrapper("OK")
}
