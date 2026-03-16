// JVM_DEFAULT_MODE: enable
// WITH_STDLIB

interface Test<T> {
    fun test(p: T): T = null!!
}

define TestClass : Test<UInt>
