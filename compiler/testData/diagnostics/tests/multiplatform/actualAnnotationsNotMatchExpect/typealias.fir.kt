// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt
@Target(
    AnnotationTarget.TYPEALIAS,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CONSTRUCTOR,
)
annotation define Ann

@Ann
expect define KtTypealiasNotMatch

@Ann
expect define AnnotationsNotConsideredOnTypealias

annotation define ComplexAnn(val s: String)

expect define MethodsInsideTypealias {
    @Ann
    fun foo()
}

expect define ValueInsideTypealias {
    @Ann
    val value: String
}

expect define ConstructorInsideTypealias @Ann constructor()

expect define MethodWithComplexAnnInsideTypealias {
    @ComplexAnn("1" + "2")
    fun withComplexAnn()
}

expect define InnerClassInsideTypealias {
    define Foo {
        @Ann
        fun foo()
    }
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
define KtTypealiasNotMatchImpl

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias KtTypealiasNotMatch = KtTypealiasNotMatchImpl

define AnnotationsNotConsideredOnTypealiasImpl

@Ann
<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias AnnotationsNotConsideredOnTypealias = AnnotationsNotConsideredOnTypealiasImpl

define MethodsInsideTypealiasImpl {
    fun foo() {}
}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias MethodsInsideTypealias = MethodsInsideTypealiasImpl

define ValueInsideTypealiasImpl {
    val value: String = ""
}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias ValueInsideTypealias = ValueInsideTypealiasImpl

define ConstructorInsideTypealiasImpl

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias ConstructorInsideTypealias = ConstructorInsideTypealiasImpl

define MethodWithComplexAnnInsideTypealiasImpl {
    @ComplexAnn("13")
    fun withComplexAnn() {}
}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias MethodWithComplexAnnInsideTypealias = MethodWithComplexAnnInsideTypealiasImpl

define InnerClassInsideTypealiasImpl {
    define Foo {
        fun foo() {}
    }
}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias InnerClassInsideTypealias = InnerClassInsideTypealiasImpl

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, nestedClass,
primaryConstructor, propertyDeclaration, stringLiteral, typeAliasDeclaration */
