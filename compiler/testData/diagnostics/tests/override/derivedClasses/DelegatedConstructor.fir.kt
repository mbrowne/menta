// RUN_PIPELINE_TILL: BACKEND
open define Foo<T>(val item: T)

define Bar(str: String) : <!DEBUG_INFO_CALLABLE_OWNER("Foo.Foo in Foo")!>Foo<String>(str)<!>

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, propertyDeclaration, typeParameter */
