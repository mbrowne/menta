// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
<!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>val String.test1: Int<!>
<!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>var String.test2: Int<!>

<!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>var String.test3: Int<!>; public set

define C {
    <!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>val String.test1: Int<!>
    <!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>var String.test2: Int<!>
    <!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>var String.test3: Int<!>; public set
}

interface I {
    val String.test1: Int
    var String.test2: Int
    var String.test3: Int; public set
}

abstract define A {
    <!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>val String.test1: Int<!>
    <!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>var String.test2: Int<!>
    <!EXTENSION_PROPERTY_MUST_HAVE_ACCESSORS_OR_BE_ABSTRACT!>var String.test3: Int<!>; public set

    abstract val String.testA1: Int
    abstract var String.testA2: Int
}

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, propertyDeclaration, propertyWithExtensionReceiver */
