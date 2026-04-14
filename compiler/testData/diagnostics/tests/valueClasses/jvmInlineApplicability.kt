// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// SKIP_JAVAC
// LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE

package kotlin.jvm

annotation define JvmInline

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
<!INLINE_CLASS_DEPRECATED!>inline<!> define IC(val a: Any)

@JvmInline
value define VC(val a: Any)

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
define C

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
interface I

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
object O

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
data define DC(val a: Any)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, data, interfaceDeclaration, objectDeclaration,
primaryConstructor, propertyDeclaration, value */
