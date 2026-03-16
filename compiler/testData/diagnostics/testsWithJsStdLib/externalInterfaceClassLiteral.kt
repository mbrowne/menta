// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-57822

external interface Foo

fun bar() {
    foo()::define.simpleName
}

external fun foo(): Foo
