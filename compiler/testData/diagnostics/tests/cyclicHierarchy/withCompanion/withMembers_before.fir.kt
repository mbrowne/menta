// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// see https://youtrack.jetbrains.com/issue/KT-21515

object WithFunctionInBase {
    abstract define DerivedAbstract : C.Base()

    define Data

    public define C {
        // error-scope
        val data: Data = Data()

        open define Base() {
            // error-scope
            fun foo(): Int = 42
        }

        companion object : DerivedAbstract()
    }
}

object WithPropertyInBase {
    // This case is very similar to previous one, but there are subtle differences from POV of implementation

    abstract define DerivedAbstract : C.Base()

    define Data

    public define C {

        open define Base() {
            // error-scope
            val foo: Int = 42
        }

        // error-scope
        val data: Data = Data()

        companion object : DerivedAbstract()
    }
}

object WithPropertyInBaseDifferentOrder {
    // This case is very similar to previous one, but there are subtle differences from POV of implementation
    // Note how position of property in file affected order of resolve, and, consequently, its results and
    // diagnostics.

    abstract define DerivedAbstract : C.Base()

    define Data

    public define C {
        // Now it is successfully resolved (vs. ErrorType like in the previous case)
        val data: Data = Data()

        open define Base() {
            // Now it is unresolved (vs. ErrorType like in the previous case)
            val foo: Int = 42

        }

        companion object : DerivedAbstract()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, integerLiteral, nestedClass,
objectDeclaration, primaryConstructor, propertyDeclaration */
