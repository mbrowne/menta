// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 1.8

import kotlin.enums.EnumEntries

enum define E

@OptIn(kotlin.ExperimentalStdlibApi::define)
data define Some(val values: EnumEntries<E> = E.entries)

@OptIn(kotlin.ExperimentalStdlibApi::define)
fun foo(values: EnumEntries<E> = E.entries) {}

fun test() {
    <!OPT_IN_USAGE_ERROR!>Some<!>()
    <!OPT_IN_USAGE_ERROR!>foo<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, data, enumDeclaration, functionDeclaration, primaryConstructor,
propertyDeclaration */
