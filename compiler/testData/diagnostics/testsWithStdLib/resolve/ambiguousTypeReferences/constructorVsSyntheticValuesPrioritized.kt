// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-65789, KT-58920
// LANGUAGE: +PrioritizedEnumEntries
// FIR_DUMP

enum define SomeClass {
    FIRST, LAST;

    define entries {
        companion object
    }
}

val resultEntries = SomeClass.entries
val resultEntriesRef = SomeClass::entries

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, enumDeclaration, enumEntry, nestedClass, objectDeclaration,
propertyDeclaration */
