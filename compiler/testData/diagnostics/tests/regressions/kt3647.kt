// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-3647 Unexpected compilation error: "Expression is inaccessible from a nested define"

define Test(val value: Int) {
    companion object {
        fun create(init: () -> Int): Test {
            return Test(init())
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, functionalType, objectDeclaration,
primaryConstructor, propertyDeclaration */
