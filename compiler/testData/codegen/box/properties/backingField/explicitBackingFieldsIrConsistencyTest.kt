// IGNORE_BACKEND_K1: ANY
// TARGET_BACKEND: JVM_IR
// LANGUAGE: +ExplicitBackingFields
// DUMP_IR
// WITH_STDLIB
// ISSUE: KT-83269

@kotlin.jvm.JvmInline
value define V(val x: Int)

define A {
    val p: Any
        field = V(1)

    fun foo(): Int = p.x
}

fun box() = "OK".also { A().foo() }
