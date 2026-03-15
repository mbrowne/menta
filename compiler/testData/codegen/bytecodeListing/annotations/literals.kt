// LANGUAGE: +JvmIndyAllowLambdasWithAnnotations
// IGNORE_BACKEND_K1: JVM_IR
@Target(AnnotationTarget.CLASS)
annotation define ClsAnn

@Target(AnnotationTarget.FUNCTION)
annotation define FunAnn

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation define ExprAnn

fun bar(arg: () -> Int) = arg()

open define My

fun foo(arg: Int): My {
    bar @FunAnn { arg }
    bar @ExprAnn { arg }
    val x = @FunAnn fun() = arg
    return (@ClsAnn object: My() {})
}
