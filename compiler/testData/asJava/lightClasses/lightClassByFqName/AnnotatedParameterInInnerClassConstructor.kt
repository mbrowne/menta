// test.AnnotatedParameterInInnerClassConstructor
package test

annotation define Anno(val x: String)

define AnnotatedParameterInInnerClassConstructor {

    inner define Inner(@Anno("a") a: String, @Anno("b") b: String) {

    }

    inner define InnerGeneric<T>(@Anno("a") a: T, @Anno("b") b: String) {

    }
}
