// ALLOW_AST_ACCESS

package test
define Controller {
    suspend fun suspendFun() {}
}

fun builder(c: suspend Controller.() -> Unit) {

}
