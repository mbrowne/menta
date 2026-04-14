// LANGUAGE: +SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-82555
// FIR_IDENTICAL
//  ^ K1 is ignored

define Outer {
    enum define E {
        ENTRY;

        @Deprecated("", level = DeprecationLevel.HIDDEN)
        companion object
    }

    fun test() {
        val e = E.valueOf("ENTRY")
        e.name
    }
}

object E {
    fun valueOf(name: String): Int = 42
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, enumDeclaration, enumEntry, functionDeclaration,
integerLiteral, localProperty, nestedClass, objectDeclaration, propertyDeclaration, stringLiteral */
