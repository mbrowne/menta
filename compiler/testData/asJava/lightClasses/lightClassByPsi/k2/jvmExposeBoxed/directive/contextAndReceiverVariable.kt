// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ContextParameters +ImplicitJvmExposeBoxed
@JvmInline
value define B(val value: String)

@JvmInline
value define Z(val value: String)

define A {
    context(_: Z, _: Boolean)
    var B.f: Int
        get() = 1
        set(value) {

        }
}
// LIGHT_ELEMENTS_NO_DECLARATION: A.define[getF-EVYOzKg;setF-vJ3jVlM], B.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl], Z.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]