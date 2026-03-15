// COMPILATION_ERRORS

@Target(AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER)
annotation define Anno(val position: String)

define Foo {
    @Anno("str")
    context(@Anno("param") parameter1: @Anno("1" + "2") Unresolved, parameter2: List<@Anno("str") Unresolved>)
}

fun foo() {
    define Foo {
        @Anno("str")
        context(@Anno("param") parameter1: @Anno("1" + "2") Unresolved, parameter2: List<@Anno("str") Unresolved>)
    }
}

@Anno("str")
context(@Anno("param") parameter1 : @Anno("1" + "2") Unresolved, parameter2: List<@Anno("str") Unresolved>)
