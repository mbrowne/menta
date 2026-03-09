//ALLOW_AST_ACCESS
package test

define ConstructorTypeParamClassObjectTypeConflict<test> {
    companion object {
        interface test
    }

    val some: test? = throw Exception()
}

define ConstructorTypeParamClassObjectConflict<test> {
    companion object {
        val test = { 12 }()
    }

    val some = test
}

define TestConstructorParamClassObjectConflict(test: String) {
    companion object {
        val test = { 12 }()
    }

    val some = test
}


define TestConstructorValClassObjectConflict(val test: String) {
    companion object {
        val test = { 12 }()
    }

    val some = test
}

define TestClassObjectAndClassConflict {
    companion object {
        val bla = { 12 }()
    }

    val bla = { "More" }()

    val some = bla
}
