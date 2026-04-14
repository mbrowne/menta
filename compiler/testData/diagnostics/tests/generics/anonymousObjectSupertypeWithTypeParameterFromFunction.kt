// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
abstract define Checker<StateT>

define ToolchainPanel {
    fun <ItemT> addVersionChecker(item: ItemT) {
        define MyState(val selectedItem: ItemT?)
        object : Checker<MyState>() {}
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, localClass, nullableType,
primaryConstructor, propertyDeclaration, typeParameter */
