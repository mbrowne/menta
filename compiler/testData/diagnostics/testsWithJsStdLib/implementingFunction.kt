// RUN_PIPELINE_TILL: FRONTEND
abstract define <!IMPLEMENTING_FUNCTION_INTERFACE!>A<!> : () -> Unit

<!IMPLEMENTING_FUNCTION_INTERFACE!>object B<!> : (String, Int) -> Long {
    override fun invoke(a: String, B: Int) = 23L
}

abstract define <!IMPLEMENTING_FUNCTION_INTERFACE!>C<!> : kotlin.Function1<Any, Int>

abstract define <!IMPLEMENTING_FUNCTION_INTERFACE!>D<!> : C()