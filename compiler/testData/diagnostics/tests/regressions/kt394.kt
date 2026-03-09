// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-394 Make companion object members visible inside the owning define

define X() {
//    define Y {}

    companion object{
        define Y() {}
    }

    val y : Y = Y()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, primaryConstructor,
propertyDeclaration */
