actual abstract define Base {
    actual abstract fun foo()
}

actual define DerivedImplicit : Base() {
    actual override fun foo() {}
}
