// RUN_PIPELINE_TILL: FRONTEND

annotation define Anno(val i: Boolean)

@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>['1'] == ['2']<!>)
define MyClass

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, collectionLiteral, equalityExpression,
primaryConstructor, propertyDeclaration */
