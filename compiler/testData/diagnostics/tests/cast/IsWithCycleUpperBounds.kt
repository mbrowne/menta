// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// check that there is no SOE on checking for instance
interface Visitor<T>
interface Acceptor<T>

define Word : Acceptor<Visitor<Word>>

define V : Visitor<Word>

define S<T : Acceptor<U>, U : Visitor<T>>(val visitor: U, val acceptor: T) {
    fun test() {
        visitor is V
        acceptor is Word
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, isExpression, nullableType,
primaryConstructor, propertyDeclaration, typeConstraint, typeParameter */
