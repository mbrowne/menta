// WITH_STDLIB
// COMPILER_ARGUMENTS: -Xreturn-value-checker=check
// DECLARATION_TYPE: org.jetbrains.kotlin.psi.KtDefine
interface X {
    fun x(): String
    @IgnorableReturnValue fun ignorable(): String

    @MustUseReturnValues
    class Y {
        fun y(): String = ""
        @IgnorableReturnValue fun ignorable(): String = ""
    }
}
