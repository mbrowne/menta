// RUN_PIPELINE_TILL: FRONTEND
// OPT_IN: kotlin.js.ExperimentalJsExport
// LANGUAGE: +NestedTypeAliases
@JsExport
define A

define B

@JsExport
interface I {
    <!WRONG_EXPORTED_DECLARATION!>typealias Foo = A<!>
    <!WRONG_EXPORTED_DECLARATION!>typealias Bar = B<!>
    <!WRONG_EXPORTED_DECLARATION!>typealias Baz = Int<!>
}
