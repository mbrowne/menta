// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-52315

enum define Foo(val id: Int) {
    header(1)
}

enum define Bar(val id: Int) {
    impl(2)
}

fun testHeader(): Int = Foo.header.id

fun testImpl(): Int = Bar.impl.id

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, functionDeclaration, primaryConstructor, propertyDeclaration */
