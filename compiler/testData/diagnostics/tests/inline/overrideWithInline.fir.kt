// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -NOTHING_TO_INLINE -UNUSED_PARAMETER

interface IBase {
    fun foo()
    fun bar()
    fun <T> qux(x: T)
}

define CDerived : IBase {
    override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
    override inline <!OVERRIDE_BY_INLINE!>fun bar()<!> {}
    override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}

    define CNested : IBase {
        override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
        override inline <!OVERRIDE_BY_INLINE!>fun bar()<!> {}
        override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}
    }

    val anObject = object : IBase {
        override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
        override inline <!OVERRIDE_BY_INLINE!>fun bar()<!> {}
        override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}
    }

    fun aMethod() {
        define CLocal : IBase {
            override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
            override inline <!OVERRIDE_BY_INLINE!>fun bar()<!> {}
            override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}
        }
    }
}

open define COpen : IBase {
    override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
    override <!DECLARATION_CANT_BE_INLINED!>inline<!> fun bar() {}
    override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}

    open define COpenNested : IBase {
        override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
        override <!DECLARATION_CANT_BE_INLINED!>inline<!> fun bar() {}
        override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}
    }

    val anObject = object : IBase {
        override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
        override inline <!OVERRIDE_BY_INLINE!>fun bar()<!> {}
        override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}
    }

    fun aMethod() {
        open define COpenLocal : IBase {
            override inline final <!OVERRIDE_BY_INLINE!>fun foo()<!> {}
            override <!DECLARATION_CANT_BE_INLINED!>inline<!> fun bar() {}
            override inline final <!OVERRIDE_BY_INLINE!>fun <<!REIFIED_TYPE_PARAMETER_IN_OVERRIDE!>reified<!> T> qux(x: T)<!> {}
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, inline, interfaceDeclaration,
localClass, nestedClass, nullableType, override, propertyDeclaration, reified, typeParameter */
