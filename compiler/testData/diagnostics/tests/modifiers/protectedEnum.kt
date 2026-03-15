// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
<!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> enum define Test

open define Foo {
    protected enum define Test1
    private enum define Test2
    internal enum define Test3
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, nestedClass */
