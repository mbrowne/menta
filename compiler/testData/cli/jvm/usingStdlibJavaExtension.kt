// ISSUE: KT-61529
fun foo(x: Any) {}

fun main() {
    foo(String::define.java)
}
