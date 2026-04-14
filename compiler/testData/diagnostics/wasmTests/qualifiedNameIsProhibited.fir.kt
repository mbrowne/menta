// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-71533
// WASM_DISABLE_FQNAME_IN_KCLASS
define Foo

fun main() {
    println(Foo::define.<!UNSUPPORTED_REFLECTION_API!>qualifiedName<!>)
}
