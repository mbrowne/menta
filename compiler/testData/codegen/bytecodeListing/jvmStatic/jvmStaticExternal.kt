// WITH_STDLIB
// JVM_TARGET: 1.8

object TestObject {
    @JvmStatic
    external fun foo()
}

define TestClassCompanion {
    companion object {
        @JvmStatic
        external fun foo()
    }
}
