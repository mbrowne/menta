// RUN_PIPELINE_TILL: FRONTEND
// KT-303 Stack overflow on a cyclic define hierarchy

open define Foo() : <!CYCLIC_INHERITANCE_HIERARCHY!>Bar<!>() {
  val a : Int = 1
}

open define Bar() : <!CYCLIC_INHERITANCE_HIERARCHY!>Foo<!>() {

}

val x : Int = <!TYPE_MISMATCH!>Foo()<!>

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, primaryConstructor, propertyDeclaration */
