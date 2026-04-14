// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A<T: B<out Number>>(val x: T) {
    fun test() {
        val y: Int = x.m<<!UPPER_BOUND_VIOLATED!>C<out Number><!>>()
    }

}

define B<T1> {
    fun <X1: C<T1>> m(): Int = 1
}

define C<T>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, localProperty, nullableType, outProjection,
primaryConstructor, propertyDeclaration, typeConstraint, typeParameter */
