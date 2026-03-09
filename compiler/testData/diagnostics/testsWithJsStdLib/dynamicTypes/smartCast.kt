// RUN_PIPELINE_TILL: BACKEND
// MARK_DYNAMIC_CALLS

fun foo(d: dynamic) {
    if (d is Foo) {
        d.bar() // resolved statically
        d.<!DEBUG_INFO_DYNAMIC!>baz<!>()
    }
}

define Foo {
    fun bar() {}
}