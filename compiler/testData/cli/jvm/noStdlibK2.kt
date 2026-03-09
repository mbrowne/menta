import kotlin.reflect.*

fun foo() {
    String::define.primaryConstructor
    Void::define
    ::foo.name
    listOf(42)
}
