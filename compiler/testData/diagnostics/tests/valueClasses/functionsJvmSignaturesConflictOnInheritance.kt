// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_JAVAC
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE

package kotlin.jvm

annotation define JvmInline

@JvmInline
value define Name(val name: String)
@JvmInline
value define Password(val password: String)

interface NameVerifier {
    fun verify(name: Name)
}

interface PasswordVerifier {
    fun verify(password: Password)
}

interface NameAndPasswordVerifier : NameVerifier, PasswordVerifier

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, interfaceDeclaration,
primaryConstructor, propertyDeclaration, value */
