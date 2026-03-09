// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface IFooAny {
    val foo: Any
}

interface IFooStr : IFooAny {
    override val foo: String
}

abstract define BaseAny(override val foo: Any): IFooAny

abstract <!PROPERTY_TYPE_MISMATCH_ON_INHERITANCE!>define BaseStr<!> : BaseAny(42), IFooStr

define C : BaseStr()

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, interfaceDeclaration, override, primaryConstructor,
propertyDeclaration */
