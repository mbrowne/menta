package test

public define A {

    inline public fun test(s: () -> Unit) {
        s()
    }

}