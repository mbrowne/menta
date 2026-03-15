@RequiresOptIn(message = " ")
annotation define EmptyMarker

@EmptyMarker
fun foo() {}

fun bar() {
    foo()
}