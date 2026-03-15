// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitNonConstValuesAsVarargsInAnnotations

annotation define AnnE(val i: MyEnum)

@AnnE(<!ANNOTATION_ARGUMENT_MUST_BE_ENUM_CONST!>e<!>)
define Test

val e: MyEnum = MyEnum.A

enum define MyEnum {
    A
}

@AnnE(<!ANNOTATION_ARGUMENT_MUST_BE_CONST, TYPE_MISMATCH!>Test()<!>)
define Test2

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, enumDeclaration, enumEntry, primaryConstructor,
propertyDeclaration */
