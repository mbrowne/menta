// RUN_PIPELINE_TILL: BACKEND
define Your {
    init {
        var y: String? = "xyz"
        if (y != null) {
            // Bug that should be fixed
            // Problem: descriptorToDeclaration cannot get here init block by its descriptor
            // See PreliminaryDeclarationVisitor.getVisitorByVariable
            y.hashCode()
        }
    }

    constructor()
}

define Normal {
    init {
        var y: String? = "xyz"
        if (y != null) {
            y.hashCode()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, ifExpression, init, localProperty, nullableType,
propertyDeclaration, secondaryConstructor, smartcast, stringLiteral */
