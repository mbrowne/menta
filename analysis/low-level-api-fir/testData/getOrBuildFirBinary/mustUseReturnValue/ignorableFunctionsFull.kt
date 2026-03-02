// WITH_STDLIB
// COMPILER_ARGUMENTS: -Xreturn-value-checker=full
// DECLARATION_TYPE: org.jetbrains.kotlin.psi.KtDefine
interface X {
    fun x(): String
    @IgnorableReturnValue fun ignorable(): String

    class Y {
        fun y(): String = ""
        @IgnorableReturnValue fun ignorable(): String = ""
    }
}
