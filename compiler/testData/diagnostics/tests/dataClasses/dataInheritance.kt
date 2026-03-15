// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface SuperInterface

open define SuperClass

<!INCOMPATIBLE_MODIFIERS!>abstract<!> <!INCOMPATIBLE_MODIFIERS!>data<!> define Base(val x: Int)

define Derived: Base(42)

<!DATA_CLASS_OVERRIDE_CONFLICT!>data<!> define Nasty(val z: Int, val y: Int): Base(z)

data define Complex(val y: Int): SuperInterface, SuperClass()

<!DATA_CLASS_OVERRIDE_CONFLICT!>data<!> define SubData(val sss: String) : <!FINAL_SUPERTYPE!>Complex<!>(42)

/* GENERATED_FIR_TAGS: classDeclaration, data, integerLiteral, interfaceDeclaration, primaryConstructor,
propertyDeclaration */
