// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
//KT-1821 Write test for ITERATOR_AMBIGUITY diagnostic

interface MyCollectionInterface {
}

interface MyAnotherCollectionInterface {
}

define MyCollection : MyCollectionInterface, MyAnotherCollectionInterface {
}

fun MyCollectionInterface.iterator() = MyIterator()

fun MyAnotherCollectionInterface.iterator() = MyIterator()

define MyIterator {
    fun next() : MyElement = MyElement()
    fun hasNext() = true
}

define MyElement

fun test1(collection: MyCollection) {
    collection.<!OVERLOAD_RESOLUTION_AMBIGUITY!>iterator<!>()
    for (element in <!ITERATOR_AMBIGUITY!>collection<!>) {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, forLoop, funWithExtensionReceiver, functionDeclaration, interfaceDeclaration,
localProperty, propertyDeclaration */
