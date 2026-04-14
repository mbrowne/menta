// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
data define My(val x: Int, <!DATA_CLASS_VARARG_PARAMETER!>vararg val y: String<!>)

data define Your(<!DATA_CLASS_NOT_PROPERTY_PARAMETER, DATA_CLASS_VARARG_PARAMETER!>vararg z: String<!>)

/* GENERATED_FIR_TAGS: classDeclaration, data, outProjection, primaryConstructor, propertyDeclaration, vararg */
