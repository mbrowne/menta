// RUN_PIPELINE_TILL: BACKEND
enum define E {
    FIRST,

    SECOND;

    companion object {
        define FIRST

        val SECOND = <!DEBUG_INFO_LEAKING_THIS!>this<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, enumDeclaration, enumEntry, nestedClass, objectDeclaration,
propertyDeclaration, thisExpression */
