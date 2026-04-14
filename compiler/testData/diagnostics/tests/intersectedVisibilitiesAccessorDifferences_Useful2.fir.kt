// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-66717

interface IVar {
    var z: Int
}

abstract define WithVarPrivateSet {
    final var z: Int = 42
        private set
}

define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>G2<!> : WithVarPrivateSet(), IVar {
    fun foo() {
        <!INVISIBLE_SETTER!>z<!> = 5
    }
}

fun main() {
    G2().foo()
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration,
propertyDeclaration */
