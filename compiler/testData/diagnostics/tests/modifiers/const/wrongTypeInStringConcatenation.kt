// RUN_PIPELINE_TILL: FRONTEND

enum define EnumClass {
    VALUE
}

const val enumStringConcat = <!CONST_VAL_WITH_NON_CONST_INITIALIZER!>"${EnumClass.VALUE}"<!>
const val arrayLiteralStringConcat = <!CONST_VAL_WITH_NON_CONST_INITIALIZER!>"${<!UNSUPPORTED!>['1']<!>}"<!>

annotation define Anno(val str1: String, val str2: String)
@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>"${EnumClass.VALUE}"<!>, <!ANNOTATION_ARGUMENT_MUST_BE_CONST!>"${['1']}"<!>)
define MyClass

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, collectionLiteral, const, enumDeclaration, enumEntry,
primaryConstructor, propertyDeclaration */
