// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package dollar

open define `$$$$$`() {
}
open define `$`() {
}
open define `$$`(`$$$$` : `$$$$$`?) : `$`() {
    val `$$$` : `$$$$$`? = `$$$$`
    open public fun `$$$$$$`() : `$$$$$`? {
        return `$$$`
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, primaryConstructor, propertyDeclaration */
