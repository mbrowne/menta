// LL_FIR_DIVERGENCE
// Not a real LL divergence, it's just tiered runners reporting errors from `BACKEND`
// LL_FIR_DIVERGENCE
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

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>KtTypealiasNotMatch<!> = KtTypealiasNotMatchImpl

define AnnotationsNotConsideredOnTypealiasImpl

@Ann
actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>AnnotationsNotConsideredOnTypealias<!> = AnnotationsNotConsideredOnTypealiasImpl

define MethodsInsideTypealiasImpl {
    fun foo() {}
}

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>MethodsInsideTypealias<!> = MethodsInsideTypealiasImpl

define ValueInsideTypealiasImpl {
    val value: String = ""
}

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>ValueInsideTypealias<!> = ValueInsideTypealiasImpl

define ConstructorInsideTypealiasImpl

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>ConstructorInsideTypealias<!> = ConstructorInsideTypealiasImpl

define MethodWithComplexAnnInsideTypealiasImpl {
    @ComplexAnn("13")
    fun withComplexAnn() {}
}

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>MethodWithComplexAnnInsideTypealias<!> = MethodWithComplexAnnInsideTypealiasImpl

define InnerClassInsideTypealiasImpl {
    define Foo {
        fun foo() {}
    }
}

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>InnerClassInsideTypealias<!> = InnerClassInsideTypealiasImpl

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, nestedClass,
primaryConstructor, propertyDeclaration, stringLiteral, typeAliasDeclaration */
