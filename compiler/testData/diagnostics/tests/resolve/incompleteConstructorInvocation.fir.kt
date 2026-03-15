// RUN_PIPELINE_TILL: FRONTEND
package p

define X<V>(provider: () -> V, trackValue: Boolean) {
}

define B {
    val c = <!NO_VALUE_FOR_PARAMETER!>X<!><String> <!ARGUMENT_TYPE_MISMATCH!>{
        "e"
    }<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, lambdaLiteral, nullableType, primaryConstructor,
propertyDeclaration, stringLiteral, typeParameter */
