// RUN_PIPELINE_TILL: FRONTEND
interface P<U, Y>

define A<T> {
    define B {
        fun test() {
            define C<W>() : P<W, <!UNRESOLVED_REFERENCE!>T<!>> {
                <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object : P<<!UNRESOLVED_REFERENCE!>W<!>, <!UNRESOLVED_REFERENCE!>T<!>> {
                }

                inner define D : P<W, <!UNRESOLVED_REFERENCE!>T<!>>
            }
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, inner, interfaceDeclaration, localClass,
nestedClass, nullableType, objectDeclaration, primaryConstructor, typeParameter */
