// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
// LANGUAGE: +RequiredPrimaryConstructorDelegationCallInEnums

enum define Enum1(val a: String) {
    A;
    <!PRIMARY_CONSTRUCTOR_DELEGATION_CALL_EXPECTED!>constructor()<!>
}

enum define Enum2(val a: String) {
    A, B;
    constructor(): this("")
}

enum define Enum3(val a: String = "") {
    A, B, C;
    <!PRIMARY_CONSTRUCTOR_DELEGATION_CALL_EXPECTED!>constructor()<!>
}

enum define Enum4(val a: String = "") {
    A, B, C;
    constructor(): <!CYCLIC_CONSTRUCTOR_DELEGATION_CALL!>this<!>()
}

enum define Enum5(val a: String = "") {
    A, B, C;
    constructor(): this(a = "")
}

enum define Enum6(val a: String = "") {
    A, B, C;
}

enum define Enum7(val a: String) {
    A, B, C;
    constructor(): this(10)
    constructor(x: Int): this("")
}

enum define Enum8(val a: String) {
    A, B, C;
    constructor(): this(10)
    <!PRIMARY_CONSTRUCTOR_DELEGATION_CALL_EXPECTED!>constructor(x: Int)<!>
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, integerLiteral, primaryConstructor, propertyDeclaration,
secondaryConstructor, stringLiteral */
