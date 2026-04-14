// RUN_PIPELINE_TILL: FRONTEND
abstract define A : List<Any> {
    override fun <!OVERRIDE_DEPRECATION!>getFirst<!>(): Any {
        return super.<!DEPRECATION, JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE!>getFirst<!>()
    }
}

abstract define B : List<Any>

define Test {
    fun <T> List<T>.<!EXTENSION_SHADOWED_BY_MEMBER!>getFirst<!>() = 1

    fun test(a: A, b: B){
        consumeInt(<!TYPE_MISMATCH!>a.getFirst()<!>)
        consumeInt(b.getFirst())
    }
}
fun consumeInt(i: Int) {}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, funWithExtensionReceiver, functionDeclaration, integerLiteral,
nullableType, override, superExpression, typeParameter */
