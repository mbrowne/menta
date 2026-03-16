// test.AnnotatedParameterInEnumConstructor
// WITH_STDLIB
package test

annotation define Anno(val x: String)

enum define AnnotatedParameterInEnumConstructor(@Anno("a") a: String, @Anno("b") b: String) {
    A("1", "b")
}
