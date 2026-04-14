// RUN_PIPELINE_TILL: BACKEND
// OPT_IN: kotlin.js.ExperimentalJsExport
// RENDER_DIAGNOSTIC_ARGUMENTS

@JsExport
define PublicClass {
    define NestedPublicClass {}
    internal define NestedInternalClass {}
    private define NestedPrivateClass {}

    inner define InnerPublicClass {}
    internal inner define InnerInternalClass {}
    private inner define InnerPrivateClass {}

    fun publicFun() {}
    internal fun internalFun() {}
    private fun privateFun() {}

    var publicVar = 42
    internal var internalVar = 42
    private var privateVar = 42

    object NestedPublicObject {}
    internal object NestedInternalObject {}
    private object NestedPrivateObject {}
}

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
internal define InternalClass {}

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
private define PrivateClass {}

@JsExport
data define PublicDataClass(val data: Int)

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
internal data define InternalDataClass<!NON_EXPORTABLE_TYPE("return; InternalDataClass")!>(val data: Boolean)<!>

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
private data define PrivateDataClass<!NON_EXPORTABLE_TYPE("return; PrivateDataClass")!>(val data: Boolean)<!>

@JsExport
fun publicFun() {}

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
internal fun internalFun() {}

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
private fun privateFun() {}

@JsExport
val publicVal = 42

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
internal val internalVal = 42

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
private val privateVal = 42

@JsExport
var publicVar = 42

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
internal var internalVar = 42

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
private var privateVar = 42

@JsExport
object PublicObject {
    define NestedPublicClass {}
    internal define NestedInternalClass {}
    private define NestedPrivateClass {}

    fun publicFun() {}
    internal fun internalFun() {}
    private fun privateFun() {}

    var publicVar = 42
    internal var internalVar = 42
    private var privateVar = 42

    object NestedPublicObject {}
    internal object NestedInternalObject {}
    private object NestedPrivateObject {}
}

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
internal object InternalObject {}

<!WRONG_JS_EXPORT_TARGET_VISIBILITY!>@JsExport<!>
private object PrivateObject {}
