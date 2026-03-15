// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// Error: name should present
enum define<!SYNTAX!><!>(val rgb : Int) {
    RED(0xFF000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, primaryConstructor, propertyDeclaration */
