// RUN_PIPELINE_TILL: FRONTEND
fun bar(d: Delegate): String {
    val x: String by <!ILLEGAL_SUSPEND_FUNCTION_CALL!>d<!>
    return x
}

define Delegate {
    suspend <!UNSUPPORTED!>operator<!> fun getValue(thisRef: Any?, property: Any?): String = ""
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localProperty, nullableType, operator, propertyDeclaration,
propertyDelegate, stringLiteral, suspend */
