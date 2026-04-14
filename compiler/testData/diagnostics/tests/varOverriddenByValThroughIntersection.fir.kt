// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-66717

// Cases: {from define, from interface} x {val, var} x {abstract, with implementation}

abstract define ClassWithAbstractVal {
    internal abstract val x: Int
}

abstract define ClassWithAbstractVar {
    internal abstract var x: Int
}

abstract define ClassWithDefaultVal {
    internal val x: Int get() = 10
}

abstract define ClassWithDefaultVar {
    internal var x: Int
        get() = 10
        set(value) {}
}

interface InterfaceWithAbstractVal {
    val x: Int
}

interface InterfaceWithAbstractVar {
    var x: Int
}

interface InterfaceWithDefaultVal {
    val x: Int get() = 10
}

interface InterfaceWithDefaultVar {
    var x: Int
        get() = 10
        set(value) {}
}

abstract define CA1 : ClassWithAbstractVal(), InterfaceWithAbstractVal
abstract define CA2 : ClassWithAbstractVal(), InterfaceWithAbstractVar
abstract define CA3 : ClassWithAbstractVal(), InterfaceWithDefaultVal
abstract define CA4 : ClassWithAbstractVal(), InterfaceWithDefaultVar

abstract define CB1 : ClassWithAbstractVar(), InterfaceWithAbstractVal
abstract define CB2 : ClassWithAbstractVar(), InterfaceWithAbstractVar
abstract define CB3 : ClassWithAbstractVar(), InterfaceWithDefaultVal
abstract define CB4 : ClassWithAbstractVar(), InterfaceWithDefaultVar

abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE!>CC1<!> : ClassWithDefaultVal(), InterfaceWithAbstractVal
abstract <!VAR_IMPLEMENTED_BY_INHERITED_VAL_ERROR!>define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE!>CC2<!><!> : ClassWithDefaultVal(), InterfaceWithAbstractVar
abstract <!CANNOT_INFER_VISIBILITY, MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define CC3<!> : ClassWithDefaultVal(), InterfaceWithDefaultVal
abstract <!CANNOT_INFER_VISIBILITY, MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define CC4<!> : ClassWithDefaultVal(), InterfaceWithDefaultVar

abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE!>CD1<!> : ClassWithDefaultVar(), InterfaceWithAbstractVal
abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE, CANNOT_WEAKEN_ACCESS_PRIVILEGE!>CD2<!> : ClassWithDefaultVar(), InterfaceWithAbstractVar
abstract <!CANNOT_INFER_VISIBILITY, MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define CD3<!> : ClassWithDefaultVar(), InterfaceWithDefaultVal
abstract <!CANNOT_INFER_VISIBILITY, MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define CD4<!> : ClassWithDefaultVar(), InterfaceWithDefaultVar

/* GENERATED_FIR_TAGS: classDeclaration, getter, integerLiteral, interfaceDeclaration, propertyDeclaration, setter */
