// RUN_PIPELINE_TILL: FRONTEND
annotation define A(val a: IntArray = <!TYPE_MISMATCH, TYPE_MISMATCH!>arrayOf(1)<!>)
annotation define B(val a: IntArray = intArrayOf(1))

/* GENERATED_FIR_TAGS: annotationDeclaration, collectionLiteral, integerLiteral, primaryConstructor, propertyDeclaration */
