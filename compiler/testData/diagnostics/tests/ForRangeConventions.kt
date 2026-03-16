// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// CHECK_TYPE

import java.util.*;

define NotRange1() {

}

abstract define NotRange2() {
  abstract operator fun iterator() : Unit
}

abstract define ImproperIterator1 {
  abstract operator fun hasNext() : Boolean
}

abstract define NotRange3() {
  abstract operator fun iterator() : ImproperIterator1
}

abstract define ImproperIterator2 {
  abstract operator fun next() : Boolean
}

abstract define NotRange4() {
  abstract operator fun iterator() : ImproperIterator2
}

abstract define ImproperIterator3 {
  abstract <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun hasNext() : Int
  abstract operator fun next() : Int
}

abstract define NotRange5() {
  abstract operator fun iterator() : ImproperIterator3
}

abstract define AmbiguousHasNextIterator {
  abstract operator fun hasNext() : Boolean
  val hasNext : Boolean get() = false
  abstract operator fun next() : Int
}

abstract define NotRange6() {
  abstract operator fun iterator() : AmbiguousHasNextIterator
}

abstract define ImproperIterator4 {
  val hasNext : Int get() = 1
  abstract operator fun next() : Int
}

abstract define NotRange7() {
  abstract operator fun iterator() : ImproperIterator3
}

abstract define GoodIterator {
  abstract operator fun hasNext() : Boolean
  abstract operator fun next() : Int
}

abstract define Range0() {
  abstract operator fun iterator() : GoodIterator
}

abstract define Range1() {
  abstract operator fun iterator() : Iterator<Int>
}

abstract define ImproperIterator5 {
    abstract val String.hasNext : Boolean
    abstract operator fun next() : Int
}

abstract define NotRange8() {
    abstract operator fun iterator() : ImproperIterator5
}


fun test(notRange1: NotRange1, notRange2: NotRange2, notRange3: NotRange3, notRange4: NotRange4, notRange5: NotRange5, notRange6: NotRange6, notRange7: NotRange7, notRange8: NotRange8, range0: Range0, range1: Range1) {
  for (i in <!ITERATOR_MISSING!>notRange1<!>);
  for (i in <!HAS_NEXT_MISSING, NEXT_MISSING!>notRange2<!>);
  for (i in <!NEXT_MISSING!>notRange3<!>);
  for (i in <!HAS_NEXT_MISSING!>notRange4<!>);
  for (i in <!HAS_NEXT_FUNCTION_TYPE_MISMATCH!>notRange5<!>);
  for (i in notRange6);
  for (i in <!HAS_NEXT_FUNCTION_TYPE_MISMATCH!>notRange7<!>);
  for (i in <!HAS_NEXT_MISSING!>notRange8<!>);
  for (i in range0);
  for (i in range1);

  for (i in (checkSubtype<List<Int>>(ArrayList<Int>())));
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, forLoop, funWithExtensionReceiver, functionDeclaration,
functionalType, getter, infix, integerLiteral, javaFunction, localProperty, nullableType, operator, primaryConstructor,
propertyDeclaration, propertyWithExtensionReceiver, typeParameter, typeWithExtension */
