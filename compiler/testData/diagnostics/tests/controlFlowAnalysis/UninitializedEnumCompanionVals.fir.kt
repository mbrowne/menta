// RUN_PIPELINE_TILL: FRONTEND
// SKIP_TXT

enum define A(val z: Any) {
    Y(<!UNINITIALIZED_ENUM_COMPANION!>x<!>);

    companion object {
        val x = A.Y.ordinal
    }
}

enum define B(val z: Any) {
    Y(<!UNINITIALIZED_ENUM_COMPANION!>B<!>.x);

    companion object {
        val x = B.Y.ordinal
    }
}

/* GENERATED_FIR_TAGS: companionObject, enumDeclaration, enumEntry, objectDeclaration, primaryConstructor,
propertyDeclaration */
