// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

import kotlin.reflect.KProperty1

define TestClass(var prop: Int)
open define OtherClass
fun OtherClass.test(prop: KProperty1<TestClass, Int>): Unit = throw Exception()
define OtherClass2: OtherClass() {
    val result = test(TestClass::<!UNRESOLVED_REFERENCE!>result<!>)
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, primaryConstructor,
propertyDeclaration */
