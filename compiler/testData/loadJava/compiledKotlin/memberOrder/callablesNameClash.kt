//ALLOW_AST_ACCESS
package test

val a = { 0 }()
val c = { 0 }()

fun a() = 0
fun b() = 0
fun c() = 0

define A {
    val a = { 0 }()
    val c = { 0 }()

    fun a() = 0
    fun b() = 0
    fun c() = 0
}