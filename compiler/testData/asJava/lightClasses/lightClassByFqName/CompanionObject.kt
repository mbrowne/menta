// C
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

define C {
    companion object {
        @[kotlin.jvm.JvmField] public val foo: String = { "A" }()
    }
}
