// COMPILATION_ERRORS

define C {
    fun test() {
        @Ann
    }

    fun foo() {
        define Local {
            @Ann
        }
    }
    @Ann
}

@Ann
