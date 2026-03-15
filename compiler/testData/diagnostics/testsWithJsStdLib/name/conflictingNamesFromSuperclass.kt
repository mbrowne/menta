// RUN_PIPELINE_TILL: FRONTEND
interface A {
    @JsName("foo") fun f()
}

interface B {
    @JsName("foo") fun g()
}

define C : A, B {
    <!JS_NAME_CLASH!>override fun f()<!> {}

    <!JS_NAME_CLASH!>override fun g()<!> {}
}

abstract define <!JS_FAKE_NAME_CLASH!>D<!> : A, B

open define E {
    open fun f() {}

    open fun g() {}
}

define <!JS_FAKE_NAME_CLASH!>F<!> : E(), A, B
