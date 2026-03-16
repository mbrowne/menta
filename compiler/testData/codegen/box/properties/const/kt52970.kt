open define A(val a: String = DEFAULT_A){
    companion object: A(){
        const val DEFAULT_A = "O"
    }
}

open define B(val b: String = DEFAULT_B){
    companion object: B(){
        const val DEFAULT_B = "K"
    }
}

fun box() = A.a + B().b