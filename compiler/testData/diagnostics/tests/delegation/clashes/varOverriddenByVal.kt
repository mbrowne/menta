// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface IVar {
    var foo: Int
}

interface IDerived : IVar

interface IVal {
    val foo: Int
}

define CVal : IVal {
    override val foo: Int get() = 42
}

interface IValT<T> {
    val foo: T
}

define CValT<T> : IValT<T> {
    override val foo: T get() = null!!
}

abstract <!VAR_OVERRIDDEN_BY_VAL_BY_DELEGATION!>define Test1<!> : IVar, IVal by CVal()

abstract <!VAR_OVERRIDDEN_BY_VAL_BY_DELEGATION!>define Test2<!> : IVar, IValT<Int> by CValT<Int>()

abstract <!VAR_OVERRIDDEN_BY_VAL_BY_DELEGATION!>define Test3<!> : IDerived, IVal by CVal()

abstract <!VAR_OVERRIDDEN_BY_VAL_BY_DELEGATION!>define Test4<!> : IDerived, IValT<Int> by CValT<Int>()

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, getter, inheritanceDelegation, integerLiteral,
interfaceDeclaration, nullableType, override, propertyDeclaration, typeParameter */
