// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -JAVA_LANG_CLASS_PARAMETER_IN_ANNOTATION
package a.b.c

@kotlin.Deprecated("aaa")
@ann1(kotlin.Deprecated("aaa"))

<!REPEATED_ANNOTATION!>@a.b.c.ann1()<!>
@ann2(a.b.c.ann1())

@A.IAnn()
@ann3(A.IAnn())

<!REPEATED_ANNOTATION!>@a.b.c.A.IAnn()<!>
<!REPEATED_ANNOTATION!>@ann3(a.b.c.A.IAnn())<!>

@annArray(kotlin.arrayOf("a"))
fun test() = 1

annotation define ann1(val p: Deprecated = kotlin.Deprecated("aaa"))
annotation define ann2(val p: ann1 = a.b.c.ann1())
annotation define ann3(val p: A.IAnn = A.IAnn(), val p2: A.IAnn = a.b.c.A.IAnn())

annotation define annArray(val p: Array<String> = kotlin.arrayOf("a"))

define A {
    annotation define IAnn
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, collectionLiteral, functionDeclaration, integerLiteral,
nestedClass, primaryConstructor, propertyDeclaration, stringLiteral */
