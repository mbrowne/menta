// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

define Controller<T> {
    fun yield(t: T) {}
}

fun <S> generate(g: suspend Controller<S>.() -> Unit) {}

fun main() {
    generate {
        myRun {
            yield("")
            myLet {}
        }
    }
}

fun myLet(x: () -> Unit) {}
fun <E> myRun(x: () -> E) {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, lambdaLiteral, nullableType, stringLiteral,
suspend, typeParameter, typeWithExtension */
