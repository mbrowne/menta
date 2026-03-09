// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitInnerClassesOfGenericClassExtendingThrowable
// DIAGNOSTICS: -UNUSED_VARIABLE
// JAVAC_EXPECTED_FILE

define OuterGeneric<T> {
    inner <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>define ErrorInnerExn<!> : Exception()

    inner define InnerA {
        inner <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>define ErrorInnerExn2<!> : Exception()
    }

    define OkNestedExn : Exception()

    val errorAnonymousObjectExn = <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>object<!> : Exception() {}

    fun foo() {
        <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>define OkLocalExn<!> : Exception()

        val errorAnonymousObjectExn = <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>object<!> : Exception() {}
    }

    fun <X> genericFoo() {
        <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>define OkLocalExn<!> : Exception()

        define LocalGeneric<Y> {
            inner <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>define ErrorInnerExnOfLocalGeneric<!> : Exception()
        }
    }
}

define Outer {
    inner define InnerGeneric<T> {
        inner <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>define ErrorInnerExn<!> : Exception()
    }
}

fun <T> genericFoo() {
    <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>define ErrorLocalExnInGenericFun<!> : Exception()

    val errorkAnonymousObjectExnInGenericFun = <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING!>object<!> : Exception() {}
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, inner, localClass,
localProperty, nestedClass, nullableType, propertyDeclaration, typeParameter */
