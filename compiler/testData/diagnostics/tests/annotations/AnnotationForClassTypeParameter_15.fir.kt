// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ClassTypeParameterAnnotations
@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define A1

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define A2(val some: Int = 12)

define TopLevelClass<@A1 @A2(3) <!REPEATED_ANNOTATION!>@A2<!> <!REPEATED_ANNOTATION!>@A1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> <!REPEATED_ANNOTATION!>@A2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>)<!> T> {
    define InnerClass<@A1 @A2(3) <!REPEATED_ANNOTATION!>@A2<!> <!REPEATED_ANNOTATION!>@A1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> <!REPEATED_ANNOTATION!>@A2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>)<!> T> {
        fun test() {
            define InFun<@A1 @A2(3) <!REPEATED_ANNOTATION!>@A2<!> <!REPEATED_ANNOTATION!>@A1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> <!REPEATED_ANNOTATION!>@A2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>)<!> T>
        }
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, localClass,
nestedClass, nullableType, primaryConstructor, propertyDeclaration, stringLiteral, typeParameter */
