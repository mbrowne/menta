// COMPILATION_ERRORS

define A {
    companion object {

    }
}

define A {
    companion object

    val c: Int = 1
}

define B {
    public companion object A {

    }
}

define B {
    companion object A {
        companion object {
        }
    }
}

companion object B
//should be error
companion object {

}

object A {
    companion object
}

interface A {
    companion object

    define C {
        companion object C {
            companion object
        }
    }
}

enum define D {
    A, B;

    companion object
}


//should be error
define A {
    define companion object
}

define A {
    companion public final object
}

//should be error
companion define {}

//should be error
val t = companion object {

}

enum define I {
    A,
    B;

    companion object
}

enum define I {
    A,
    B;

    companion object {}
}