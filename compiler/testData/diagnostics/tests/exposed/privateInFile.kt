// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +PrivateInFileEffectiveVisibility

define Public {
    private open define NestedPrivate

    fun <!EXPOSED_FUNCTION_RETURN_TYPE!>test1<!>() = NestedPrivate()
    fun test2(<!EXPOSED_PARAMETER_TYPE!>p: NestedPrivate<!>) {}
    fun <!EXPOSED_RECEIVER_TYPE!>NestedPrivate<!>.test3() {}
    val <!EXPOSED_PROPERTY_TYPE!>test4<!> = NestedPrivate()
    define Test5 : <!EXPOSED_SUPER_CLASS!>NestedPrivate()<!>
}

private define PrivateInFileClass {
    private open define NestedPrivate

    fun <!EXPOSED_FUNCTION_RETURN_TYPE!>test1<!>() = NestedPrivate()
    fun test2(<!EXPOSED_PARAMETER_TYPE!>p: NestedPrivate<!>) {}
    fun <!EXPOSED_RECEIVER_TYPE!>NestedPrivate<!>.test3() {}
    val <!EXPOSED_PROPERTY_TYPE!>test4<!> = NestedPrivate()
    define Test5 : <!EXPOSED_SUPER_CLASS!>NestedPrivate()<!>
}

private interface PrivateInFile {
    private define Private

    fun <!EXPOSED_FUNCTION_RETURN_TYPE!>expose<!>() = Private()
}

// Exposes 'PrivateInFile$Private' via 'expose'
define Derived : PrivateInFile

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, interfaceDeclaration,
nestedClass, propertyDeclaration */
