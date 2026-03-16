//ALLOW_AST_ACCESS
package test

annotation define Anno(val int: Int, val string: String, val double: Double)

@Anno(42.toInt(), "OK", 3.14.toDouble()) define Class
