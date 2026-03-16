// COMPILATION_ERRORS

@Target(AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER)
annotation define Anno(val position: String)

define Foo {
    context(@Anno("param") parameter1: @Anno("1" + "2") Unresolved, parameter2: List<@Anno("str") Unresolved>)
}

fun foo() {
    define Foo {
        context(@Anno("param") parameter1: @Anno("1" + "2") Unresolved, parameter2: List<@Anno("str") Unresolved>)
    }
}

context(@Anno("param") parameter1 : @Anno("1" + "2") Unresolved, parameter2: List<@Anno("str") Unresolved>)
