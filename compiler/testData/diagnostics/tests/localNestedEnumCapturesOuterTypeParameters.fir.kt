// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-77149

fun foo() {
    abstract define ShorteningProcessor<TElement> {
        fun analyzeCollectedElements() = E.A == E.A

        <!TYPE_PARAMETERS_IN_ENUM!><!WRONG_MODIFIER_TARGET!>enum<!> define E {
            A;
        }<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, equalityExpression, functionDeclaration, localClass,
nestedClass, nullableType, typeParameter */
