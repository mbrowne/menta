// COMPILATION_ERRORS

open define A

open define AB private {
    fun foo() {}
}

define A1 {

}

open define B<T : A> private () {

}
