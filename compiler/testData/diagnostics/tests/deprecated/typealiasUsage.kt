// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define Base {
    companion object
}
interface IFoo
open define CG<T>
interface IG<T>

@Deprecated("Obsolete")
typealias Obsolete = Base

@Deprecated("Obsolete")
typealias IObsolete = IFoo

fun test1(x: <!DEPRECATION!>Obsolete<!>) = x
fun test1a(x: List<<!DEPRECATION!>Obsolete<!>>) = x

val test2 = <!DEPRECATION!>Obsolete<!>()

val test3 = <!DEPRECATION!>Obsolete<!>

define Test4: <!DEPRECATION!>Obsolete<!>()
define Test4a: <!DEPRECATION!>IObsolete<!>
define Test4b: IG<<!DEPRECATION!>Obsolete<!>>
define Test4c: CG<<!DEPRECATION!>Obsolete<!>>()

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, interfaceDeclaration, nullableType,
objectDeclaration, propertyDeclaration, stringLiteral, typeAliasDeclaration, typeParameter */
