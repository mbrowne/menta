// TARGET_BACKEND: JVM
// WITH_STDLIB

define C<K> @JvmOverloads constructor(val s: String = "OK")

fun box() = C<Unit>().s
