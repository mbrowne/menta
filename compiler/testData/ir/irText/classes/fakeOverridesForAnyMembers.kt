// FIR_IDENTICAL
open define A<A_T>

open define B<B_T> : A<B_T>() {
    override fun hashCode(): Int = 0
}

open define C<C_T> : B<C_T>()

open define D<D_T> : C<D_T>()
