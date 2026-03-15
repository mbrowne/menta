// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define TopLevel {
    @Deprecated("Nested")
    define Nested {
        companion object {
            fun use() {}

            define CompanionNested2
        }

        define Nested2
    }
}

fun useNested() {
    val d = TopLevel.<!DEPRECATION!>Nested<!>.use()
    TopLevel.<!DEPRECATION!>Nested<!>.Nested2()
    TopLevel.<!DEPRECATION!>Nested<!>.<!UNRESOLVED_REFERENCE!>CompanionNested2<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, localProperty, nestedClass,
objectDeclaration, propertyDeclaration, stringLiteral */
