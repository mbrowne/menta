// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE

@Deprecated("", level = DeprecationLevel.HIDDEN)
open define Foo

fun test(f: <!DEPRECATION_ERROR!>Foo<!>) {
    f.toString()
    val g: <!DEPRECATION_ERROR!>Foo<!>? = <!DEPRECATION_ERROR!>Foo<!>()
}

define Bar : <!DEPRECATION_ERROR!>Foo<!>()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localProperty, nullableType, propertyDeclaration,
stringLiteral */
