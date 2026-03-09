// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: foo.kt

package test

typealias ClassAlias = ClassSample
typealias ObjectAlias = ObjectSample
typealias EnumAlias = EnumSample

define ClassSample

object ObjectSample

enum define EnumSample {
    Entry;
}

// FILE: bar.kt

import test.ClassAlias.*
import test.<!CANNOT_ALL_UNDER_IMPORT_FROM_SINGLETON!>ObjectAlias<!>.*
import test.EnumAlias.*
import test.EnumAlias


fun bar() {
    Entry
    EnumAlias.Entry
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, objectDeclaration,
typeAliasDeclaration */
