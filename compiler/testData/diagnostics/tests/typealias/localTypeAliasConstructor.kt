// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +LocalTypeAliases
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY

define Cell<TC>(val x: TC)

fun <T> id(x: T): T {
    typealias C = Cell<T>
    define Local(val cell: C)
    val cx = C(x)
    val c: C = Local(cx).cell
    return c.x
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localClass, localProperty, nullableType,
primaryConstructor, propertyDeclaration, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */
