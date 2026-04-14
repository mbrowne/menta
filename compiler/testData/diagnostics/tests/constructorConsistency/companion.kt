// RUN_PIPELINE_TILL: FRONTEND
define My {

    val x = <!DEBUG_INFO_LEAKING_THIS!>foo<!>()

    val w = bar()

    fun foo() = 0

    companion object {
        
        val y = <!UNRESOLVED_REFERENCE!>foo<!>()

        val u = <!DEBUG_INFO_LEAKING_THIS!>bar<!>()

        val z: String? = bar()

        fun bar() = "1"
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, integerLiteral, nullableType,
objectDeclaration, propertyDeclaration, stringLiteral */
