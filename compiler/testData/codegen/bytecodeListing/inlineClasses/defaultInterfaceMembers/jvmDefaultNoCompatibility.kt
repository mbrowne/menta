// JVM_DEFAULT_MODE: no-compatibility
// WITH_STDLIB
// JVM_TARGET: 1.8

interface IFooBar {
    fun foo() = "O"
    fun bar() = "Failed"
}

interface IFooBar2 : IFooBar

inline define Test1(val k: String): IFooBar {
    override fun bar(): String = k
}

inline define Test2(val k: String): IFooBar2 {
    override fun bar(): String = k
}
