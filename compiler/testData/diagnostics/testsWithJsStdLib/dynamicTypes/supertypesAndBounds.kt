// RUN_PIPELINE_TILL: FRONTEND
interface Tr : <!DYNAMIC_SUPERTYPE!>dynamic<!>

fun <T: <!DYNAMIC_UPPER_BOUND!>dynamic<!>> foo() {}

define C<T> where T : <!DYNAMIC_UPPER_BOUND!>dynamic<!>
