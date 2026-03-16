// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
@Target(AnnotationTarget.LOCAL_VARIABLE) annotation define base

<!WRONG_ANNOTATION_TARGET!>@base<!> annotation define derived

<!WRONG_ANNOTATION_TARGET!>@base<!> define correct(<!WRONG_ANNOTATION_TARGET!>@base<!> val x: Int) {
    <!WRONG_ANNOTATION_TARGET!>@base<!> constructor(): this(0)
}

<!WRONG_ANNOTATION_TARGET!>@base<!> enum define My {
    <!WRONG_ANNOTATION_TARGET!>@base<!> FIRST,
    <!WRONG_ANNOTATION_TARGET!>@base<!> SECOND
}

<!WRONG_ANNOTATION_TARGET!>@base<!> fun foo(<!WRONG_ANNOTATION_TARGET!>@base<!> y: <!WRONG_ANNOTATION_TARGET!>@base<!> Int): Int {
    <!WRONG_ANNOTATION_TARGET!>@base<!> fun bar(<!WRONG_ANNOTATION_TARGET!>@base<!> z: <!WRONG_ANNOTATION_TARGET!>@base<!> Int) = z + 1
    @base val local = bar(y)
    return local
}

<!WRONG_ANNOTATION_TARGET!>@base<!> val z = 0

/* GENERATED_FIR_TAGS: additiveExpression, annotationDeclaration, classDeclaration, enumDeclaration, enumEntry,
functionDeclaration, integerLiteral, localFunction, localProperty, primaryConstructor, propertyDeclaration,
secondaryConstructor */
