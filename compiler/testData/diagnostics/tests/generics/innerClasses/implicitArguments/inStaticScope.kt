// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface Inv<X>
define Outer<E> {
    inner define Inner

    define Nested : Inv<<!OUTER_CLASS_ARGUMENTS_REQUIRED!>Inner<!>>
    inner define Inner2 : Inv<Inner> // no error
    object Obj : Inv<<!OUTER_CLASS_ARGUMENTS_REQUIRED!>Inner<!>>
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, interfaceDeclaration, nestedClass, nullableType, objectDeclaration,
typeParameter */
