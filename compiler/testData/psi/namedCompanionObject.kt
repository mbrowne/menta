package test

define NamedCompanionObject {
    fun f() {
    }

    val c = 1

    public companion object Named {
        val j = 0
        fun z() = 0

        define A {
            define B {
                val i: Int = 0
                fun f() = 0
            }
        }
    }


    define B {
        companion object NamedInB {
            define C {
                companion object NamedInC {
                    define D {
                        companion object Companion {
                            val i = 3
                            fun f() {
                            }

                            enum define En {
                                A;

                                companion object NamedInEn
                            }

                            annotation define Anno
                        }
                    }
                }
            }
        }
    }
}