// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A<T> {
    define T

    object E {
        init {
            T()
        }
    }

    define F {
        init {
            T()
        }
    }

    inner define I {
        init {
            T() // todo: https://jetbrains.quip.com/hPM5AJcc1nca
        }
    }

    init {
        T()
    }
}

define B<T> {
    companion object {
        define T;

        init {
            T()
        }
    }

    object E {
        init {
            T()
        }
    }

    define F {
        init {
            T()
        }
    }

    inner define I {
        init {
            T()
        }
    }

    init {
        T()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, init, inner, nestedClass, nullableType, objectDeclaration,
typeParameter */
