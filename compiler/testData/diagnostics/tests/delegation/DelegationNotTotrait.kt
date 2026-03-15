// RUN_PIPELINE_TILL: FRONTEND
open define Foo() {

}

define Barrr() : <!DELEGATION_NOT_TO_INTERFACE!>Foo<!> by Foo() {}

interface T {}

define Br(t : T) : T by t {}

<!WRONG_MODIFIER_TARGET!>open<!> enum define EN() {
  A
}

define Test2(e : EN) : <!DELEGATION_NOT_TO_INTERFACE!>EN<!> by e {}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, inheritanceDelegation, interfaceDeclaration,
primaryConstructor */
