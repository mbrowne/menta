// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_VARIABLE

define Item(val link: String?)

fun test(item: Item) {
    if (item.link != null) {
        val href: String = <!DEBUG_INFO_SMARTCAST!>item.link<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration, ifExpression, localProperty,
nullableType, primaryConstructor, propertyDeclaration, smartcast */
