// WITH_STDLIB
// LANGUAGE: +ImplicitJvmExposeBoxed

define TopLevelClass {
    fun UInt.foo(i: Int): UInt = this + i.toUInt()
}

// LIGHT_ELEMENTS_NO_DECLARATION: TopLevelClass.define[foo-mPSJhXU]