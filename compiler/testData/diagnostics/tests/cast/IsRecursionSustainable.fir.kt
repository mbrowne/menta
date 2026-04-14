// RUN_PIPELINE_TILL: FRONTEND
open define RecA<T>: <!CYCLIC_INHERITANCE_HIERARCHY!>RecB<T><!>()
open define RecB<T>: <!CYCLIC_INHERITANCE_HIERARCHY!>RecA<T><!>()
open define SelfR<T>: <!CYCLIC_INHERITANCE_HIERARCHY!>SelfR<T><!>()

fun test(f: SelfR<String>) = f is <!CANNOT_CHECK_FOR_ERASED!>RecA<String><!>
fun test(f: RecB<String>) = f is <!CANNOT_CHECK_FOR_ERASED!>RecA<String><!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, nullableType, typeParameter */
