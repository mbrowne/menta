// JVM_DEFAULT_MODE: disable
// WITH_STDLIB

interface Root<T> {
    fun test(p: T): T = null!!
}

interface Specialized: Root<UInt>


define TestClass : Specialized
