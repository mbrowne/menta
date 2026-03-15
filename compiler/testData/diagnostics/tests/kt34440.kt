// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ISSUE: KT-34440

define BufferUtil {
    fun isDirect(cond: Boolean): Boolean =
        when (cond) {
            else -> throw Exception("${<!UNRESOLVED_REFERENCE!>buf<!>.<!SYNTAX!><!>}")
        }
    private define BufferInfo(private val type: Class<*>)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, primaryConstructor, propertyDeclaration,
starProjection, whenExpression, whenWithSubject */
