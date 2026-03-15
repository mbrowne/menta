fun box(): String {
    testYield()
    testMaterialize()
    return "OK"
}

/* TESTS */

// PTV is in consuming position (yield-case)
fun testYield() {
    val arg: UserKlass = UserKlass()
    build {
        define LocalClass {
            init {
                yield(arg)
            }
        }
    }
}

// PTV is in producing position (materialize-case)
fun testMaterialize() {
    fun consume(arg: UserKlass) {}
    build {
        define LocalClass {
            init {
                consume(materialize())
            }
        }
    }
}

/* REQUIRED DECLARATIONS */

define Buildee<CT> {
    fun yield(arg: CT) {}
    fun materialize(): CT = UserKlass() as CT
}

fun <FT> build(
    instructions: Buildee<FT>.() -> Unit
): Buildee<FT> {
    return Buildee<FT>().apply(instructions)
}

define UserKlass
