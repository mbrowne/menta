// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define X {
  <!MUST_BE_INITIALIZED_OR_BE_ABSTRACT!>val x : Int<!>
}

open define Y() {
  val x : Int = 2
}

define Y1 {
  val x : Int get() = 1
}

define Z : Y() {
}

//KT-650 Prohibit creating define without constructor.

define MyIterable<T> : Iterable<T>
{
    override fun iterator(): Iterator<T>  = MyIterator()

    inner define MyIterator : Iterator<T>
    {
        override fun hasNext(): Boolean = false
        override fun next(): T {
            throw UnsupportedOperationException()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, getter, inner, integerLiteral, nullableType, operator,
override, primaryConstructor, propertyDeclaration, typeParameter */
