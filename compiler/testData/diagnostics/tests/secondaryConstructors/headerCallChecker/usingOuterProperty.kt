// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
define Outer {
    val prop = 1
    inner define Inner {
        constructor(x: Int)
        constructor(x: Int, y: Int, z: Int = x + prop + this@Outer.prop) : this(x + prop + this@Outer.prop)
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, inner, integerLiteral, propertyDeclaration,
secondaryConstructor, thisExpression */
