// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

annotation define A1 <!OVERLOADS_ANNOTATION_CLASS_CONSTRUCTOR_ERROR!>@JvmOverloads<!> constructor(val x: Int = 1)
annotation define A2 <!OVERLOADS_ANNOTATION_CLASS_CONSTRUCTOR_ERROR!>@JvmOverloads<!> constructor()

/* GENERATED_FIR_TAGS: annotationDeclaration, integerLiteral, primaryConstructor, propertyDeclaration */
