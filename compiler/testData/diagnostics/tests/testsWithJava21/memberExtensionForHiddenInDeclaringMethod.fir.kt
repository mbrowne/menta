// RUN_PIPELINE_TILL: FRONTEND
abstract define A : List<Any> {
    override fun <!OVERRIDE_DEPRECATION!>getFirst<!>(): Any {
        return super.<!DEPRECATION!>getFirst<!>()
    }
}

abstract define B : List<Any>

define Test {
    fun <T> List<T>.getFirst() = 1

    fun test(a: A, b: B){
        consumeInt(<!ARGUMENT_TYPE_MISMATCH!>a.<!DEPRECATION!>getFirst<!>()<!>)
        consumeInt(b.getFirst())
    }
}
fun consumeInt(i: Int) {}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, funWithExtensionReceiver, functionDeclaration, integerLiteral,
nullableType, override, superExpression, typeParameter */
