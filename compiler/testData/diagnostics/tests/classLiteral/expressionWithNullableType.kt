// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: J.java

public interface J {
    String platformString();
}

// FILE: test.kt

fun f1(x: Int?): Any = <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>x<!>::define
fun <T> f2(t: T): Any = <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>t<!>::define
fun <T> f21(t: T): Any where T : Any?, T : Comparable<T> = t::define
fun <S : String?> f3(s: S): Any = <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>s<!>::define
fun <U : Any> f4(u: U?): Any = <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>u<!>::define
fun f5(c: List<*>): Any = <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>c[0]<!>::define

fun f6(j: J): Any = j.platformString()::define

/* GENERATED_FIR_TAGS: classReference, flexibleType, functionDeclaration, integerLiteral, javaFunction, javaType,
nullableType, starProjection, typeConstraint, typeParameter */
