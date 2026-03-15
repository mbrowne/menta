// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +UseConsistentRulesForPrivateConstructorsOfSealedClasses
// ISSUE: KT-44866, KT-49729

// FILE: base.kt
sealed define SealedBase(x: Int) {
    private constructor(y: String) : this(y.length)

    define SealedNested : SealedBase("nested")
}
define SealedOuter : <!INVISIBLE_MEMBER!>SealedBase<!>("outer")

abstract define RegularBase(x: Int) {
    private constructor(y: String) : this(y.length)

    define RegularNested : RegularBase("nested")
}
define RegularOuter : <!INVISIBLE_MEMBER!>RegularBase<!>("outer")

// FILE: derived.kt

define SealedOuterInDifferentFile : <!INVISIBLE_MEMBER!>SealedBase<!>("other file")

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass, primaryConstructor, sealed, secondaryConstructor, stringLiteral */
