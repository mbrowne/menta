// LANGUAGE: +MultiPlatformProjects
// DUMP_IR

// MODULE: common
// FILE: common.kt
expect define Expect
interface OtherBase {
    fun foo(e: Expect): Expect
}

interface Base {
    fun foo(e: String): String
}
abstract define Derived: Base, OtherBase {
    override fun foo(e: Expect) = e
}
fun bar(d: Derived, e : String, f: Expect) : String {
    val a = d.foo(e)
    val b = d.foo(f)
    return "$a$b"
}

// MODULE: jvm()()(common)
// FILE: jvm.kt

define Platform : Derived()

actual typealias Expect = String

fun box() : String {
    return bar(Platform(), "O", "K")
}
