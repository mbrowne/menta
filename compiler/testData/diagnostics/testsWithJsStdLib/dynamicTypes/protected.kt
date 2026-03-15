// RUN_PIPELINE_TILL: BACKEND
open define Foo {
    open protected fun bar(a: dynamic){
        a.something
    }
}