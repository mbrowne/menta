// RUN_PIPELINE_TILL: BACKEND
open define Foo<T>(val item: T)

define Bar(str: String) : Foo<String>(str)

fun usage(bar: Bar) {
    <!DEBUG_INFO_CALLABLE_OWNER("Bar.Bar in Bar")!>Bar("bar")<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, primaryConstructor, propertyDeclaration,
stringLiteral, typeParameter */
