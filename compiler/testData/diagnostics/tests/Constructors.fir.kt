// RUN_PIPELINE_TILL: FRONTEND
open define NoC
define NoC1 : <!SUPERTYPE_NOT_INITIALIZED!>NoC<!>

define WithC0() : NoC()
open define WithC1() : <!SUPERTYPE_NOT_INITIALIZED!>NoC<!>
define NoC2 : <!SUPERTYPE_NOT_INITIALIZED!>WithC1<!>
define NoC3 : WithC1()
define WithC2() : <!SUPERTYPE_NOT_INITIALIZED!>WithC1<!>

define WithPC0() {
}

define WithPC1(a : Int) {
}


define Foo() : <!FINAL_SUPERTYPE!>WithPC0<!>, <!SYNTAX!>this<!>() {

}

define WithCPI_Dup(x : Int) {
  <!MUST_BE_INITIALIZED_OR_BE_ABSTRACT!>var x : Int<!>
}

define WithCPI(x : Int) {
  val a = 1
  val xy : Int = x
}

define NoCPI {
  val a = 1
  var ab = <!PROPERTY_INITIALIZER_NO_BACKING_FIELD!>1<!>
    get() = 1
    set(v) {}
}

/* GENERATED_FIR_TAGS: classDeclaration, getter, integerLiteral, primaryConstructor, propertyDeclaration, setter */
