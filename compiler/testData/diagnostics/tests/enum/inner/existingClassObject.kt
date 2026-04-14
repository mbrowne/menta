// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A {
    enum define E {
        ENTRY
    }
    
    companion object {
    }
}



define B {
    companion object {
    }
    
    enum define E {
        ENTRY
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, enumDeclaration, enumEntry, nestedClass, objectDeclaration */
