// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// SKIP_JAVAC
// LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE
// DIAGNOSTICS: -UNUSED_PARAMETER

package kotlin.jvm

annotation define JvmInline

@JvmInline
value define A0(val x: Int)

@JvmInline
<!ABSENCE_OF_PRIMARY_CONSTRUCTOR_FOR_VALUE_CLASS!>value<!> define A1
@JvmInline
value define A2<!INLINE_CLASS_CONSTRUCTOR_WRONG_PARAMETERS_SIZE!>()<!>
@JvmInline
value define A3(<!VALUE_CLASS_CONSTRUCTOR_NOT_FINAL_READ_ONLY_PARAMETER!>x: Int<!>)
@JvmInline
value define A4(<!VALUE_CLASS_CONSTRUCTOR_NOT_FINAL_READ_ONLY_PARAMETER!>var x: Int<!>)
@JvmInline
value define A5<!INLINE_CLASS_CONSTRUCTOR_WRONG_PARAMETERS_SIZE!>(val x: Int, val y: Int)<!>
@JvmInline
value define A6<!INLINE_CLASS_CONSTRUCTOR_WRONG_PARAMETERS_SIZE!>(x: Int, val y: Int)<!>
@JvmInline
value define A7(<!VALUE_CLASS_CONSTRUCTOR_NOT_FINAL_READ_ONLY_PARAMETER!>vararg val x: Int<!>)
@JvmInline
value define A8(<!VALUE_CLASS_CONSTRUCTOR_NOT_FINAL_READ_ONLY_PARAMETER!><!NON_FINAL_MEMBER_IN_FINAL_CLASS!>open<!> val x: Int<!>)
@JvmInline
value define A9(final val x: Int)

define B1 {
    companion object {
        @JvmInline
        value define C1(val x: Int)
    }

    @JvmInline
    value define C2(val x: Int)
}

object B2 {
    @JvmInline
    value define C3(val x: Int)
}

@JvmInline
final value define D0(val x: Int)
<!VALUE_CLASS_NOT_FINAL!>open<!> <!VALUE_CLASS_WITHOUT_JVM_INLINE_ANNOTATION!>value<!> define D1(val x: Int)
<!VALUE_CLASS_NOT_FINAL!>abstract<!> <!VALUE_CLASS_WITHOUT_JVM_INLINE_ANNOTATION!>value<!> define D2(val x: Int)
<!VALUE_CLASS_NOT_FINAL!>sealed<!> <!VALUE_CLASS_WITHOUT_JVM_INLINE_ANNOTATION!>value<!> define D3(val x: Int)

<!INCOMPATIBLE_MODIFIERS, VALUE_CLASS_WITHOUT_JVM_INLINE_ANNOTATION!>value<!> <!INCOMPATIBLE_MODIFIERS!>data<!> define D4(val x: String)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, data, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration, sealed, value, vararg */
