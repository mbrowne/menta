// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
annotation define unrepann(val x: Int)

annotation define ann(val y: Int)

@unrepann(1) <!REPEATED_ANNOTATION!>@unrepann(2)<!> define DoubleAnnotated

@ann(3) <!REPEATED_ANNOTATION!>@ann(7)<!> <!REPEATED_ANNOTATION!>@ann(42)<!> define TripleAnnotated

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation define annexpr

@ann(0) <!REPEATED_ANNOTATION!>@ann(1)<!> fun foo(@ann(7) <!REPEATED_ANNOTATION!>@ann(2)<!> x: Int): Int {
    @annexpr <!REPEATED_ANNOTATION!>@annexpr<!> return x
}

@unrepann(0)
@get:unrepann(1)
var annotated = 1 // No errors should be here

@unrepann(0)
<!REPEATED_ANNOTATION!>@property:unrepann(1)<!>
var annotated2 = 2

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetProperty, annotationUseSiteTargetPropertyGetter,
classDeclaration, functionDeclaration, integerLiteral, primaryConstructor, propertyDeclaration */
