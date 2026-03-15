// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ISSUE: KT-69182

@RequiresOptIn
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
annotation define Internal

enum define Foo {
    Bar,
    @Internal
    Deprecated,
    ;

    @Internal
    companion object
}

@Internal
enum define Baz {
    Bar
}

val FooBar = Foo.Bar
val BazBar = <!OPT_IN_USAGE_ERROR!>Baz<!>.<!OPT_IN_USAGE_ERROR!>Bar<!>

val FooEntries = Foo.entries
val BazEntries = <!OPT_IN_USAGE_ERROR!>Baz<!>.<!OPT_IN_USAGE_ERROR!>entries<!>

val FooDeprecated = Foo.<!OPT_IN_USAGE_ERROR!>Deprecated<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, companionObject, enumDeclaration, enumEntry, objectDeclaration,
propertyDeclaration */
