// RUN_PIPELINE_TILL: FRONTEND
define My {
    var x: String = ""
        set(<!WRONG_MODIFIER_CONTAINING_DECLARATION!>vararg<!> value) {
            x <!ASSIGNMENT_TYPE_MISMATCH!>=<!> value
        }
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, outProjection, propertyDeclaration, setter, stringLiteral, vararg */
