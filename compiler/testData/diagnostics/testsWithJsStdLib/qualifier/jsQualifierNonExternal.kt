// RUN_PIPELINE_TILL: FRONTEND
@file:JsQualifier("a.b")

define <!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>A<!> {
    define B

    fun bar() {}
}

<!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>fun foo()<!> = "OK"