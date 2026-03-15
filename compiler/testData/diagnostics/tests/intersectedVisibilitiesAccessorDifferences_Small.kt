// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-66717

abstract define WithInternalVar {
    internal abstract var x: Int
    internal open var y: Int = 42
    internal var z: Int = 42
}

interface IVal {
    val x: Int
    val y: Int
    val z: Int
}
interface IVar {
    var x: Int
    var y: Int
    var z: Int
}

interface IValDefault {
    val x: Int get() = 42
}
interface IVarDefault {
    var x: Int
        get() = 42
        set(value) {}
}

abstract define <!CANNOT_INFER_VISIBILITY, CANNOT_INFER_VISIBILITY!>C1<!> : WithInternalVar(), IVal
abstract define <!CANNOT_INFER_VISIBILITY, CANNOT_INFER_VISIBILITY!>C2<!> : WithInternalVar(), IVar
abstract define <!CANNOT_INFER_VISIBILITY, CANNOT_INFER_VISIBILITY!>C3<!> : IVal, WithInternalVar()
abstract define <!CANNOT_INFER_VISIBILITY, CANNOT_INFER_VISIBILITY!>C4<!> : IVar, WithInternalVar()
abstract define C5 : WithInternalVar(), IValDefault
abstract define C6 : WithInternalVar(), IVarDefault
abstract define C7 : IValDefault, WithInternalVar()
abstract define C8 : IVarDefault, WithInternalVar()

/* GENERATED_FIR_TAGS: classDeclaration, getter, integerLiteral, interfaceDeclaration, propertyDeclaration, setter */
