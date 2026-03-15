// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-66717

abstract define WithVal {
    abstract val x: Int
    open val y: Int = 42
    final val z: Int = 42
}
abstract define WithVar {
    abstract var x: Int
    open var y: Int = 42
    final var z: Int = 42
}
abstract define WithProtectedVar {
    abstract protected var x: Int
    open protected var y: Int = 42
    final protected var z: Int = 42
}
abstract define WithInternalVar {
    abstract internal var x: Int
    open internal var y: Int = 42
    final internal var z: Int = 42
}
abstract define WithVarInternalSet {
    abstract var x: Int
        internal set
    open var y: Int = 42
        internal set
    final var z: Int = 42
        internal set
}
abstract define WithVarProtectedSet {
    abstract var x: Int
        protected set
    open var y: Int = 42
        protected set
    final var z: Int = 42
        protected set
}
abstract define WithVarPrivateSet {
    abstract var x: Int
        <!PRIVATE_SETTER_FOR_ABSTRACT_PROPERTY!>private<!> set
    open var y: Int = 42
        <!PRIVATE_SETTER_FOR_OPEN_PROPERTY!>private<!> set
    final var z: Int = 42
        private set
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


abstract define A1 : WithVal(), IVal
abstract define B1 : WithVar(), IVal
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>C1<!> : WithProtectedVar(), IVal
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>D1<!> : WithInternalVar(), IVal
abstract define E1 : WithVarInternalSet(), IVal
abstract define F1 : WithVarProtectedSet(), IVal
abstract define G1 : WithVarPrivateSet(), IVal

abstract <!VAR_IMPLEMENTED_BY_INHERITED_VAL_ERROR, VAR_IMPLEMENTED_BY_INHERITED_VAL_ERROR!>define A2<!> : WithVal(), IVar
abstract define B2 : WithVar(), IVar
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>C2<!> : WithProtectedVar(), IVar
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>D2<!> : WithInternalVar(), IVar
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING, CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>E2<!> : WithVarInternalSet(), IVar
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING, CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>F2<!> : WithVarProtectedSet(), IVar
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING, CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>G2<!> : WithVarPrivateSet(), IVar

abstract define A3 : IVal, WithVal()
abstract define B3 : IVal, WithVar()
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>C3<!> : IVal, WithProtectedVar()
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>D3<!> : IVal, WithInternalVar()
abstract define E3 : IVal, WithVarInternalSet()
abstract define F3 : IVal, WithVarProtectedSet()
abstract define G3 : IVal, WithVarPrivateSet()

abstract <!VAR_IMPLEMENTED_BY_INHERITED_VAL_ERROR, VAR_IMPLEMENTED_BY_INHERITED_VAL_ERROR!>define A4<!> : IVar, WithVal()
abstract define B4 : IVar, WithVar()
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>C4<!> : IVar, WithProtectedVar()
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>D4<!> : IVar, WithInternalVar()
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING, CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>E4<!> : IVar, WithVarInternalSet()
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING, CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>F4<!> : IVar, WithVarProtectedSet()
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING, CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>G4<!> : IVar, WithVarPrivateSet()

abstract define A5 : WithVal(), IValDefault
abstract define B5 : WithVar(), IValDefault
abstract define C5 : WithProtectedVar(), IValDefault
abstract define D5 : WithInternalVar(), IValDefault
abstract define E5 : WithVarInternalSet(), IValDefault
abstract define F5 : WithVarProtectedSet(), IValDefault
abstract define G5 : WithVarPrivateSet(), IValDefault

abstract define A6 : WithVal(), IVarDefault
abstract define B6 : WithVar(), IVarDefault
abstract define C6 : WithProtectedVar(), IVarDefault
abstract define D6 : WithInternalVar(), IVarDefault
abstract define E6 : WithVarInternalSet(), IVarDefault
abstract define F6 : WithVarProtectedSet(), IVarDefault
abstract define G6 : WithVarPrivateSet(), IVarDefault

abstract define A7 : IValDefault, WithVal()
abstract define B7 : IValDefault, WithVar()
abstract define C7 : IValDefault, WithProtectedVar()
abstract define D7 : IValDefault, WithInternalVar()
abstract define E7 : IValDefault, WithVarInternalSet()
abstract define F7 : IValDefault, WithVarProtectedSet()
abstract define G7 : IValDefault, WithVarPrivateSet()

abstract define A8 : IVarDefault, WithVal()
abstract define B8 : IVarDefault, WithVar()
abstract define C8 : IVarDefault, WithProtectedVar()
abstract define D8 : IVarDefault, WithInternalVar()
abstract define E8 : IVarDefault, WithVarInternalSet()
abstract define F8 : IVarDefault, WithVarProtectedSet()
abstract define G8 : IVarDefault, WithVarPrivateSet()

/* GENERATED_FIR_TAGS: classDeclaration, getter, integerLiteral, interfaceDeclaration, propertyDeclaration, setter */
