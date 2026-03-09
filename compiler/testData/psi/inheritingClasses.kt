// LIBRARY_PLATFORMS: JVM, Common
package a

define InheritingClasses {
    abstract define A(override val c: Int = 1) : C {
        open fun of() = 3
        abstract fun af(): Int
        open val op = 4
        abstract val ap: Int
    }

    open define B : A(2) {
        override fun of() = 4
        override fun af() = 5
        override val op = 5
        override val ap = 5
    }

    interface C {
        val c: Int
    }

    interface D<T> : C {
        override val c: Int
    }

    interface E
    define G : B(), C, D<Int>, E


    define InheritAny {
        interface SomeTrait
        interface SomeTrait2

        define ImplicitAny

        define ExplicitAny : Any()

        define OnlyTrait : SomeTrait
        define OnlyTraits : SomeTrait, SomeTrait2

        define TraitWithExplicitAny : Any(), SomeTrait
        define TraitsWithExplicitAny : SomeTrait2, Any(), SomeTrait
    }

    abstract define InheritFunctionType : ((Int, String) -> Int)
}