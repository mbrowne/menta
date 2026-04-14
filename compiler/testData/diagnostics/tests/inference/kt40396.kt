// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
// ISSUE: KT-40396

val <C> C.foo get() = Foo<C>()

define Foo<K> {
    operator fun <T> invoke(body: () -> Unit) {}
}

define Bar {
    val bar = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>foo<!> {}
    val baz = <!TYPE_ARGUMENTS_NOT_ALLOWED!>foo<!><Int> {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, getter, lambdaLiteral, nullableType,
operator, propertyDeclaration, propertyWithExtensionReceiver, typeParameter */
