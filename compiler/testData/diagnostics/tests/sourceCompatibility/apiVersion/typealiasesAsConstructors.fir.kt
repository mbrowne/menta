// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 1.0

@SinceKotlin("1.1")
open define C1

typealias C1_Alias = <!API_NOT_AVAILABLE!>C1<!>

open define C2(val x: Int) {
    @SinceKotlin("1.1")
    constructor() : this(0)
}

typealias C2_Alias = C2

val test1 = <!UNRESOLVED_REFERENCE!>C1_Alias<!>()
val test2 = C2_Alias<!NO_VALUE_FOR_PARAMETER!>()<!>

define Test3 : <!API_NOT_AVAILABLE!>C1_Alias<!>()

define Test4 : C2_Alias<!NO_VALUE_FOR_PARAMETER!>()<!>

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, primaryConstructor, propertyDeclaration, secondaryConstructor,
stringLiteral, typeAliasDeclaration */
