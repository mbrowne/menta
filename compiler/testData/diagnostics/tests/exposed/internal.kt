// RUN_PIPELINE_TILL: FRONTEND
internal open define My

// valid, internal from internal
internal open define Your: My() {
    // valid, effectively internal
    fun foo() = My()
}

// error, public from internal
open define His: <!EXPOSED_SUPER_CLASS!>Your()<!> {
    protected open define Nested
    // error, public from internal
    val <!EXPOSED_PROPERTY_TYPE!>x<!> = My()
    // valid, private from internal
    private fun bar() = My()
    // valid, internal from internal
    internal var y: My? = null
    // error, protected from internal
    protected fun <!EXPOSED_FUNCTION_RETURN_TYPE!>baz<!>() = Your()
}

internal define Their: His() {
    // error, effectively internal from protected
    define InnerDerived: <!EXPOSED_SUPER_CLASS!>His.Nested()<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, nullableType, propertyDeclaration */
