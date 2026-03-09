// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-71533
// FIR_IDENTICAL
define Foo

fun main() {
    println(Foo::define.qualifiedName)
}
