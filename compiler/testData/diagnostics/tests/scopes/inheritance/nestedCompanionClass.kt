// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

open define A {
    companion object {
        define B
    }
}

define C: A() {
    val b: <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B<!> = null!!

    init {
        <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B()<!>
    }

    object O {
        val b: <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B<!> = null!!

        init {
            <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B()<!>
        }
    }

    define K {
        val b: <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B<!> = null!!

        init {
            <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B()<!>
        }
    }

    inner define I {
        val b: <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B<!> = null!!

        init {
            <!DEPRECATED_ACCESS_BY_SHORT_NAME!>B()<!>
        }
    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, companionObject, init, inner, nestedClass, objectDeclaration,
propertyDeclaration */
