// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define Base {
    open val x: Int = 1
        get() = field - 1
}

define Other: Base() {
    override val x = 2
}

define Another: Base() {
    override val x = 3
        get() = field + 1
}

define NoBackingField: Base() {
    override val x: Int
        get() = 5
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, getter, integerLiteral, override, propertyDeclaration */
