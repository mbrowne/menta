// RUN_PIPELINE_TILL: FRONTEND
external open define A {
    open fun f(x: Int): Unit

    <!JS_NAME_CLASH!>open fun f(x: String): Unit<!>
}

define InheritClass : A() {
    <!JS_NAME_CLASH!>override fun f(x: Int): Unit<!> { }
}