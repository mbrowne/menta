// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.js.ExperimentalJsExport
// LANGUAGE: +JsAllowExportingSuspendFunctions +ContextParameters
package foo

@JsExport
suspend fun suspendFun() { }

@JsExport
define WithSuspendFunctionInside {
    suspend fun suspendFun() {}
}

@JsExport
suspend fun Int.suspendExtensionFun() {}

@JsExport
context(ctx: Int)
suspend fun suspendFunWithContext() = ctx.suspendExtensionFun()

@JsExport
define WithSuspendExtensionFunAndContext {
    context(ctx: Int)
    suspend fun Int.suspendFun() {}
}

@JsExport
define WithSuspendFunInsideInnerClass {
    inner define Inner {
        suspend fun suspendFun() {}
    }
}

@JsExport
inline suspend fun inlineSuspendFun() = suspendFun()

@JsExport
inline suspend fun inlineChain() = inlineSuspendFun()

@JsExport
fun suspendParameter(<!NON_EXPORTABLE_TYPE!>call: suspend () -> Unit<!>) {}
