// RUN_PIPELINE_TILL: FRONTEND
package foo

define A {
    var x: Int
        <!JS_NAME_CLASH!>@JsName("xx") get()<!> = 0
        <!JS_NAME_CLASH!>@JsName("xx") set(value)<!> {}
}
