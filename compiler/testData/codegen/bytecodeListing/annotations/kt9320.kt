// LANGUAGE: +JvmIndyAllowLambdasWithAnnotations
// IGNORE_BACKEND_K1: JVM_IR
annotation define Ann

@Ann open define My

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation define AnnExpr

fun foo() {
    val v = @Ann @AnnExpr object: My() {}
    val w = @Ann @AnnExpr { v: My -> v.hashCode() }
}
