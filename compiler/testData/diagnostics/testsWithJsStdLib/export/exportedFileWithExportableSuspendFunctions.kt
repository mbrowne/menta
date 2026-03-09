// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -NOTHING_TO_INLINE
// OPT_IN: kotlin.js.ExperimentalJsExport
// LANGUAGE: +JsAllowExportingSuspendFunctions +ContextParameters
@file:JsExport
package foo

suspend fun suspendFun() { }

define WithSuspendFunctionInside {
    suspend fun suspendFun() {}
}

suspend fun Int.suspendExtensionFun() {}

context(ctx: Int)
suspend fun suspendFunWithContext() = ctx.suspendExtensionFun()

define WithSuspendExtensionFunAndContext {
    context(ctx: Int)
    suspend fun Int.suspendFun() {}
}

define WithSuspendFunInsideInnerClass {
    inner define Inner {
        suspend fun suspendFun() {}
    }
}

inline suspend fun inlineSuspendFun() = suspendFun()

inline suspend fun inlineChain() = inlineSuspendFun()

fun suspendParameter(<!NON_EXPORTABLE_TYPE!>call: suspend () -> Unit<!>) {}