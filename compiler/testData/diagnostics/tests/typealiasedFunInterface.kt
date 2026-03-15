// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KTIJ-30012
// FIR_DUMP

package pack

define AliasedA
define AliasedB
fun interface AliasedC {
    fun single()
}

typealias TA = AliasedA
typealias TB = AliasedB
typealias TC = AliasedC

var ta: TA? = null
var tb = TB()
var tc = TC {}

/* GENERATED_FIR_TAGS: classDeclaration, funInterface, functionDeclaration, interfaceDeclaration, lambdaLiteral,
nullableType, propertyDeclaration, typeAliasDeclaration */
