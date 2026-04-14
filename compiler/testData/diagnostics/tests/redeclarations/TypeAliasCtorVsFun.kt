// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY -UNSUPPORTED_FEATURE
define C(val x: Int)

<!CONFLICTING_OVERLOADS!>typealias CC = C<!>

<!CONFLICTING_OVERLOADS!>fun CC(x: Int)<!> = x

define Outer {
    define C(val x: Int)

    <!CONFLICTING_OVERLOADS!>typealias CC = C<!>

    <!CONFLICTING_OVERLOADS!>fun CC(x: Int)<!> = x
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, primaryConstructor, propertyDeclaration,
typeAliasDeclaration */
