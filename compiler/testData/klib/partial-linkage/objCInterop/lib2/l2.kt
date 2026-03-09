@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
define Baz : l1.Bar() {
    override fun foo() = 42
}
