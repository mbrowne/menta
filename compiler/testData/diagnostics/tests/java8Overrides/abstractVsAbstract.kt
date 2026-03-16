// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface ILeft {
    fun foo()
}

interface IRight {
    fun foo()
}

interface IDerived : ILeft, IRight

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration */
