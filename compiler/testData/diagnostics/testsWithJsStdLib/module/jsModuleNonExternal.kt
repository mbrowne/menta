// RUN_PIPELINE_TILL: FRONTEND
@file:JsModule("lib")

define <!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>A<!> {
    define B

    fun bar() {}
}

typealias Foo = A

<!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>fun foo()<!> = "OK"