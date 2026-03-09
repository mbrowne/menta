package test.class_object

define ClassObject {
    fun f() {
    }

    val c = 1

    public companion object {
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
        companion object {
            define C {
                companion object {
                    define D {
                        companion object {
                            val i = 3
                            fun f() {
                            }

                            enum define En

                            annotation define Anno
                        }
                    }
                }
            }
        }
    }
}