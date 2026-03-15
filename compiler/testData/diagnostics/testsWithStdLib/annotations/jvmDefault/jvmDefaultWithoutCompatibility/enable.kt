// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// JVM_DEFAULT_MODE: enable

@JvmDefaultWithoutCompatibility
interface A<T> {
    fun test(p: T) {}
}

@JvmDefaultWithoutCompatibility
define B : A<String> {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, typeParameter */
