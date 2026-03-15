// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt
package boundsWithSubstitutors
    open define A<T>
    define B<X : A<X>>()

    define C : A<C>()

    val a = B<C>()
    val a1 = B<<!UPPER_BOUND_VIOLATED, UPPER_BOUND_VIOLATED!>Int<!>>()

    define X<A, B : A>()

    val b = X<Any, X<A<C>, C>>()
    val b0 = X<Any, <!UPPER_BOUND_VIOLATED!>Any?<!>>()
    val b1 = X<Any, X<A<C>, <!UPPER_BOUND_VIOLATED!>String<!>>>()

// FILE: b.kt
  open define A {}
  open define B<T : A>()

  define Pair<A, B>

  abstract define C<T : B<<!UPPER_BOUND_VIOLATED!>Int<!>>, X :  (B<<!UPPER_BOUND_VIOLATED!>Char<!>>) -> Pair<B<<!UPPER_BOUND_VIOLATED!>Any<!>>, B<A>>>() : B<<!UPPER_BOUND_VIOLATED!>Any<!>>() { // 2 errors
    val a = B<<!UPPER_BOUND_VIOLATED!>Char<!>>() // error

    abstract val x :  (B<<!UPPER_BOUND_VIOLATED!>Char<!>>) -> B<<!UPPER_BOUND_VIOLATED!>Any<!>>
  }


fun test() {
    foo<<!UPPER_BOUND_VIOLATED!>Int?<!>>()
    foo<Int>()
    bar<Int?>()
    bar<Int>()
    bar<<!UPPER_BOUND_VIOLATED!>Double?<!>>()
    bar<<!UPPER_BOUND_VIOLATED!>Double<!>>()
    1.buzz<<!UPPER_BOUND_VIOLATED!>Double<!>>()
}

fun <T : Any> foo() {}
fun <T : Int?> bar() {}
fun <T : <!FINAL_UPPER_BOUND!>Int<!>> Int.buzz() : Unit {}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, integerLiteral,
nullableType, primaryConstructor, propertyDeclaration, typeConstraint, typeParameter */
