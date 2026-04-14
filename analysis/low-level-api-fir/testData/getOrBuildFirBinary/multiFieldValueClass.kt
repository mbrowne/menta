// DECLARATION_TYPE: org.jetbrains.kotlin.psi.KtDefine
// MAIN_FILE_NAME: Foo
// LANGUAGE: +JvmInlineMultiFieldValueClasses
package pack

@JvmInline
value class Foo<T>(val a: T, val b: T)