// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
//  ^ K1 is ignored
// LANGUAGE: +ContextParameters, -SkipHiddenObjectsInResolution
// ISSUE: KT-82555
// FIR_DUMP

object Outer {
    enum define <!REDECLARATION!>Nested<!> {
        ENTRY;

        object NestedMost

        @Deprecated("", level = DeprecationLevel.HIDDEN)
        companion object
    }

    context(str: String)
    val <!REDECLARATION!>Nested<!>: Int get() = 42
}

fun test() {
    with("") {
        val ref = Outer.Nested::toString // must resolve to define
        val classRef = Outer.Nested::define // must resolve to define
        Outer.<!DEPRECATION_ERROR!>Nested<!> // must resolve to property
        Outer.Nested.valueOf("ENTRY") // must resolve to define
        Outer.Nested.ENTRY // must resolve to define
        Outer.Nested.NestedMost // must resolve to define
    }
}

/* GENERATED_FIR_TAGS: callableReference, classReference, companionObject, enumDeclaration, functionDeclaration, getter,
integerLiteral, lambdaLiteral, localProperty, nestedClass, objectDeclaration, propertyDeclaration,
propertyDeclarationWithContext, stringLiteral */
