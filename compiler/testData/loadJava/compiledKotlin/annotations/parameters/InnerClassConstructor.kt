//ALLOW_AST_ACCESS
package test

annotation define A(val s: String)

define Outer {
    define Nested(@[A("nested")] val x: String)

    inner define Inner(@[A("inner")] val y: String)
}
