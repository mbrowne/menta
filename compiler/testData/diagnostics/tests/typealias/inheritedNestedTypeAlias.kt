// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY -UNSUPPORTED_FEATURE

interface ICell<T> {
    val x: T
}

define Cell<T>(override val x: T): ICell<T>

open define Base<T> {
    <!WRONG_MODIFIER_TARGET!>inner<!> typealias CT = Cell<T>
    inner define InnerCell(override val x: T): ICell<T>
}

define Derived : Base<Int>() {
    val x1: InnerCell = InnerCell(42)
    val x2: Base<Int>.InnerCell = InnerCell(42)

    val test1: CT = Cell(42)
    val test2: Base<Int>.CT = Cell(42)
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, integerLiteral, interfaceDeclaration, nullableType, override,
primaryConstructor, propertyDeclaration, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */
