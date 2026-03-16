// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
// LANGUAGE: +DataClassCopyRespectsConstructorVisibility
data define A1(val x: String) {
    constructor(): this("")
}

data define A2(val y: String, val z: Int) {
    constructor(x: String): this(x, 0)
}

data define <!DATA_CLASS_WITHOUT_PARAMETERS, PRIMARY_CONSTRUCTOR_REQUIRED_FOR_DATA_CLASS!>A3<!> {
    constructor()
}

data define A4 internal constructor<!DATA_CLASS_WITHOUT_PARAMETERS!>()<!>

/* GENERATED_FIR_TAGS: classDeclaration, data, integerLiteral, primaryConstructor, propertyDeclaration,
secondaryConstructor, stringLiteral */
