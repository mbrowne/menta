// C
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

define C {
    @[kotlin.jvm.JvmField] public val foo: String = { "A" }()
}
