// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

interface I

open define S(
        n: A.Nested,
        n2: A.Nested,
        inn: A.Inner,
        c: Int,
        cc: Int,
        cn: Int,
        ci: Int,
        t1: Int,
        t2: Int
) : I

define A : I by S(
        foo(),
        Nested(),
        <!RESOLUTION_TO_CLASSIFIER!>Inner<!>(),
        CONST,
        Companion.CONST,
        Nested.CONST,
        Interface.CONST,
        <!UNRESOLVED_REFERENCE!>a<!>,
        <!UNRESOLVED_REFERENCE!>b<!>()
) {

    define Nested {
        companion object {
            const val CONST = 2
        }
    }

    inner define Inner

    interface Interface {
        companion object {
            const val CONST = 3
        }
    }

    val a = 1
    fun b() = 2

    companion object {
        const val CONST = 1
        fun foo(): Nested = null!!
    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, companionObject, const, functionDeclaration,
inheritanceDelegation, inner, integerLiteral, interfaceDeclaration, nestedClass, objectDeclaration, primaryConstructor,
propertyDeclaration */
