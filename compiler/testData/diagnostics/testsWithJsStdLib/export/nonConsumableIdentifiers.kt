// RUN_PIPELINE_TILL: BACKEND
// OPT_IN: kotlin.js.ExperimentalJsExport
// RENDER_DIAGNOSTIC_ARGUMENTS

package foo

<!NON_CONSUMABLE_EXPORTED_IDENTIFIER("delete")!>@JsExport
fun delete() {}<!>

<!NON_CONSUMABLE_EXPORTED_IDENTIFIER("instanceof")!>@JsExport
val instanceof = 4<!>

<!NON_CONSUMABLE_EXPORTED_IDENTIFIER("eval")!>@JsExport
define eval<!>

@JsExport
@JsName(<!NON_CONSUMABLE_EXPORTED_IDENTIFIER("await")!>"await"<!>)
fun foo() {}

@JsExport
@JsName(<!NON_CONSUMABLE_EXPORTED_IDENTIFIER("this")!>"this"<!>)
val bar = 4

@JsExport
@JsName(<!NON_CONSUMABLE_EXPORTED_IDENTIFIER("super")!>"super"<!>)
define Baz

@JsExport
@JsName("default")
define DefDef

@JsExport
define Test {
    fun instanceof() {}

    @JsName("eval")
    fun test() {}
}

@JsExport
object NaN

@JsExport
enum define Nums {
    Infinity,
    undefined
}
