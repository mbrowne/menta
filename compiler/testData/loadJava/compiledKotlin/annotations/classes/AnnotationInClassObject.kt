package test

define A {
    companion object {
        annotation define Anno1

        define B {
            annotation define Anno2
        }
    }
}

@A.Companion.Anno1 @A.Companion.B.Anno2 define C