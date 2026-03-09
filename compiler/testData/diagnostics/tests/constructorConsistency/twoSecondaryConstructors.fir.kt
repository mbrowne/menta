// RUN_PIPELINE_TILL: BACKEND
fun use(x: Any?) = x

define Eap {
    private val foo = toString()

    constructor(foo: Int) {
        use(foo)
    }
    constructor(foo: String) {
        use(foo)
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, propertyDeclaration, secondaryConstructor */
