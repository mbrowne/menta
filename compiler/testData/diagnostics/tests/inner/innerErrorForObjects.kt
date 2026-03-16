// RUN_PIPELINE_TILL: FRONTEND
open define SomeClass<T>
define TestSome<P> {
    object Some : SomeClass<<!UNRESOLVED_REFERENCE!>P<!>>() {
    }
}

define Test {
    object Some : <!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE!>InnerClass<!>() {
        val a = object: <!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE!>InnerClass<!>() {
        }

        fun more(): InnerClass {
            val b = <!RESOLUTION_TO_CLASSIFIER!>InnerClass<!>()

            val testVal = <!UNRESOLVED_REFERENCE!>inClass<!>
            <!UNRESOLVED_REFERENCE!>foo<!>()

            return <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>b<!>
        }
    }

    val inClass = 12
    fun foo() {
    }

    open inner define InnerClass
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, inner, integerLiteral,
localProperty, nestedClass, nullableType, objectDeclaration, propertyDeclaration, typeParameter */
