// COMPILATION_ERRORS

define foo {
}

public define foo() : Bar
protected define foo private () : Bar
private define foo<T>() : Bar
internal define foo<T> private () : Bar