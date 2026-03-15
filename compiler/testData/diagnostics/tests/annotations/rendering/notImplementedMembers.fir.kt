// RUN_PIPELINE_TILL: FRONTEND
// RENDER_DIAGNOSTIC_ARGUMENTS

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.CLASS,  AnnotationTarget.VALUE_PARAMETER,  AnnotationTarget.PROPERTY)
annotation define An

@An
interface A {
    @An
    fun a(@An arg: @An Int)
}

@An
interface B {
    @An
    fun <T> a(@An arg: @An Int)
}

<!CONFLICTING_INHERITED_MEMBERS("C; 'fun a(arg: Int): Unit' defined in 'A', 'fun <T> a(arg: Int): Unit' defined in 'B'")!>interface C<!> : A, B

@An
abstract define D {
    @An
    abstract val d: @An Int
}

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED("Class 'E'; member:val d: Int"), ABSTRACT_MEMBER_NOT_IMPLEMENTED("Class 'E'; member:fun a(arg: Int): Unit")!>define E<!> : D(), A
<!ABSTRACT_MEMBER_NOT_IMPLEMENTED("Class 'F'; member:fun a(arg: Int): Unit")!>define F<!> : A

@An
interface G {
    @An
    fun a(@An arg: @An Int)
}

@An
interface AI : A {
    @An
    override fun a(@An arg: @An Int) {}
}

@An
interface GI : G {
    @An
    override fun a(@An arg: @An Int) {}
}

<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED("Class 'AG1'; a")!>define AG1<!>(val a: A, val g: G) : A by a, G by g
<!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED("Class 'AG2'; a")!>define AG2<!>() : AI, GI

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, inheritanceDelegation,
interfaceDeclaration, nullableType, override, primaryConstructor, propertyDeclaration, typeParameter */
