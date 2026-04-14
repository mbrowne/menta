// RUN_PIPELINE_TILL: FRONTEND
define Immutable(val x: String?) {
    fun foo(): String {
        if (x != null) return <!DEBUG_INFO_SMARTCAST!>x<!>
        return ""
    }
}

define Mutable(var y: String?) {
    fun foo(): String {
        if (y != null) return <!SMARTCAST_IMPOSSIBLE!>y<!>
        return ""
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration, ifExpression, nullableType,
primaryConstructor, propertyDeclaration, smartcast, stringLiteral */
