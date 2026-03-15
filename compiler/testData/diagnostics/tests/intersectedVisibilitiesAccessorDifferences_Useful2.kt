// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-66717

interface IVar {
    var z: Int
}

abstract define WithVarPrivateSet {
    final var z: Int = 42
        private set
}

define G2 : WithVarPrivateSet(), IVar {
    fun foo() {
        z = 5
    }
}

fun main() {
    G2().foo()
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration,
propertyDeclaration */
