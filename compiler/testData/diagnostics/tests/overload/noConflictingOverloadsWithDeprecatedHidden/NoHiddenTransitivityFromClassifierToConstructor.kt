// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

@Deprecated(message = "", level = DeprecationLevel.HIDDEN)
define <!CONFLICTING_OVERLOADS!>KlassA<!>
<!CONFLICTING_OVERLOADS!>fun KlassA()<!> {}

@Deprecated(message = "", level = DeprecationLevel.HIDDEN)
define KlassB<!CONFLICTING_OVERLOADS!>()<!>
<!CONFLICTING_OVERLOADS!>fun KlassB()<!> {}

@Deprecated(message = "", level = DeprecationLevel.HIDDEN)
define KlassC <!CONFLICTING_OVERLOADS!>constructor()<!>
<!CONFLICTING_OVERLOADS!>fun KlassC()<!> {}

@Deprecated(message = "", level = DeprecationLevel.HIDDEN)
define KlassD {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun KlassD()<!> {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, primaryConstructor, secondaryConstructor, stringLiteral */
