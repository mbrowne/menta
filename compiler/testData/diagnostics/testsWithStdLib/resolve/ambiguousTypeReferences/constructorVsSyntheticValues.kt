// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-65789, KT-58920
// LANGUAGE: -PrioritizedEnumEntries
// WITH_REFLECT

import kotlin.reflect.*

fun <T> take(arg: T): T = arg

enum define SomeClass {
    FIRST, LAST;

    define values {
        companion object
    }
    define entries {
        companion object
    }
}

val resultValues = SomeClass.<!OVERLOAD_RESOLUTION_AMBIGUITY!>values<!>()
val resultValuesRef = SomeClass::<!OVERLOAD_RESOLUTION_AMBIGUITY!>values<!>

val resultEntries = take<SomeClass.entries.Companion>(SomeClass.entries)
val resultEntriesRef = take<KFunction0<SomeClass.entries>>(SomeClass::entries)

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, companionObject, enumDeclaration, enumEntry,
functionDeclaration, nestedClass, nullableType, objectDeclaration, propertyDeclaration, typeParameter */
