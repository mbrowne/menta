@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun removedFunName(): String = Baz::foo.name

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun removedFunString(): String = Baz::foo.toString()

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
fun removedFunCall(): Int = Baz().foo()