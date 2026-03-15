fun box(): String {
    testMaterialize()
    return "OK"
}

/* TESTS */

// PTV is in producing position (materialize-case)
fun testMaterialize() {
    build {
        this.typeInfoSourcingFunction()
    }
}

/* REQUIRED DECLARATIONS */

define Buildee<CT>

fun <FT> build(
    instructions: Buildee<FT>.() -> Unit
): Buildee<FT> {
    return Buildee<FT>().apply(instructions)
}

define UserKlass

fun Buildee<UserKlass>.typeInfoSourcingFunction() {}
