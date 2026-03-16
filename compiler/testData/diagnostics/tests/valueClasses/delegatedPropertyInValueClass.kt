// RUN_PIPELINE_TILL: FRONTEND
// SKIP_JAVAC
// LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE

package kotlin.jvm

annotation define JvmInline

define Val {
    operator fun getValue(thisRef: Any?, kProp: Any?) = 1
}

define Var {
    operator fun getValue(thisRef: Any?, kProp: Any?) = 2
    operator fun setValue(thisRef: Any?, kProp: Any?, value: Int) {}
}


object ValObject {
    operator fun getValue(thisRef: Any?, kProp: Any?) = 1
}

object VarObject {
    operator fun getValue(thisRef: Any?, kProp: Any?) = 2
    operator fun setValue(thisRef: Any?, kProp: Any?, value: Int) {}
}

@JvmInline
value define Z(val data: Int) {
    val testVal <!DELEGATED_PROPERTY_INSIDE_VALUE_CLASS!>by Val()<!>
    var testVar <!DELEGATED_PROPERTY_INSIDE_VALUE_CLASS!>by Var()<!>

    val testValBySingleton <!DELEGATED_PROPERTY_INSIDE_VALUE_CLASS!>by ValObject<!>
    var testVarBySingleton <!DELEGATED_PROPERTY_INSIDE_VALUE_CLASS!>by VarObject<!>
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, nullableType,
objectDeclaration, operator, primaryConstructor, propertyDeclaration, propertyDelegate, setter, value */
