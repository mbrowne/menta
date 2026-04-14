//ALLOW_AST_ACCESS
package test

annotation define Anno(val value: String)

define Constructor @Anno(value = "string") constructor()
