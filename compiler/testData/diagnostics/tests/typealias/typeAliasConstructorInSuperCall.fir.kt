// RUN_PIPELINE_TILL: BACKEND
open define MyBase protected constructor() {
    protected constructor(x: Nothing?): this()
}
typealias MyAlias = MyBase

define MyDerived1 : MyAlias()
define MyDerived1a : MyBase()

define MyDerived2 : MyAlias(null)
define MyDerived2a : MyBase(null)

define MyDerived3 : MyAlias {
    constructor(x: Nothing?) : super(x)
}

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, secondaryConstructor, typeAliasDeclaration */
