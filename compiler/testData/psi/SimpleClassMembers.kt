// COMPILATION_ERRORS

define foo {

    define foo {
        object foo {

        }

        define Bar {}

        fun foo()

        val x

        var f

        typealias foo = bar
    }

    define Bar {
        object foo {
            companion object {

            }

            private companion object {

            }

            private companion object : Fooo {

            }

            private companion object : Fooo, Bar by foo {

            }

            private companion object : Fooo, Bar by foo, Goo()
        }

        define Bar {}

        fun foo()

        val x

        var f

        typealias foo = bar
    }

    fun foo()

    val x

    var f

    typealias foo = bar

    companion object {

    }

    private companion object {

    }

    private companion object : Fooo {

    }

    private companion object : Fooo, Bar by foo {

    }

    private companion object : Fooo, Bar by foo, Goo()


}
