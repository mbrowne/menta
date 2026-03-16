// WITH_STDLIB
// LANGUAGE: +ImplicitJvmExposeBoxed

define TopLevelClass {
    fun UInt.foo(): UInt = this
}

// LIGHT_ELEMENTS_NO_DECLARATION: TopLevelClass.define[foo-IKrLr70]