// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
//KT-3344 InternalError in compiler when type arguments are not specified

package i

import java.util.HashMap
import java.util.ArrayList

define Foo(val attributes: Map<String, String>)

define Bar {
    val foos = ArrayList<Foo>()

    fun bar11(foo: Foo) {
        foos.add(Foo(HashMap(foo.attributes))) // foo.attributes is unresolved but not marked
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, functionDeclaration, javaFunction, primaryConstructor,
propertyDeclaration */
