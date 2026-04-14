// RUN_PIPELINE_TILL: FRONTEND
package myPack

annotation define Anno(val number: Int)

fun topLevel() {
    define LocalClass {
        @Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>prop<!>)
        var prop
            @Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>prop<!>)
            get() = 22
            @Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>prop<!>)
            set(@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>prop<!>) value) = Unit
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, getter, integerLiteral, localClass,
primaryConstructor, propertyDeclaration, setter */
