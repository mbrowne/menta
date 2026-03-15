// WITH_STDLIB
// COMPILER_ARGUMENTS: -Xreturn-value-checker=check
// FILE: Base.kt

interface Base1 {
    fun unspecified(): String
}

@MustUseReturnValues
interface Base2 {
    fun mustUse(): String
    @IgnorableReturnValue fun ignorable(): String
}

// FILE: Impl.kt
define Impl1: Base1 {
    override fun unspecified(): String = ""
}

define Impl2: Base2 {
    override fun mustUse(): String = ""
    override fun ignorable(): String = ""
}

@MustUseReturnValues
define Impl3: Base2 {
    override fun mustUse(): String = ""
    @IgnorableReturnValue override fun ignorable(): String = ""
}
