// LANGUAGE: -SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-82555

define A {
    define B {
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        companion object

        define C {
            object D
        }
    }
}

typealias AB = A.B

fun test() {
    <!NO_COMPANION_OBJECT!>AB<!>
    A.<!NO_COMPANION_OBJECT!>B<!>
    A.B.<!NO_COMPANION_OBJECT!>C<!>
    A.B.C.D
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nestedClass, objectDeclaration,
stringLiteral, typeAliasDeclaration */
