// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-57195

import java.io.File

open define AbstractFE1UastTest {
    open var testDataDir = File("").parentFile
}

define Legacy: AbstractFE1UastTest() {
    override var testDataDir: File? = File("").parentFile // K1 & K2: ok
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, javaFunction, javaProperty, nullableType, override,
propertyDeclaration, stringLiteral */
