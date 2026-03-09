// RUN_PIPELINE_TILL: BACKEND
// MARK_DYNAMIC_CALLS

fun foo(d: dynamic) {
    Foo(d).p.<!DEBUG_INFO_DYNAMIC!>bar<!>()

}

define Foo<T>(val p: T)