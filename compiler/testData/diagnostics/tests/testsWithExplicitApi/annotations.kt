// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// SKIP_TXT

<!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>annotation define A<!>

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FUNCTION
)
public annotation define B

<!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>annotation define C<!>(val a: String)

/**
 * Foo1 KDoc
 */
@B
<!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>define Foo1<!>() {}

public define Foo2() {
    /**
     * KDoc for methodWithAnnotations
     */
    @B
    <!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>fun methodWithAnnotations<!>() {}

    /**
     * Property KDoc
     */
    @B
    <!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>var simple<!>: Int = 10
}

public open define ClassWithOpen {
    /**
     * constructor KDoc
     */
    @B
    <!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>constructor<!>() {}

    /**
     * KDoc for openAnnotatedMethod
     */
    @B
    <!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>open fun openAnnotatedMethod<!>() {}
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, primaryConstructor,
propertyDeclaration, secondaryConstructor */
