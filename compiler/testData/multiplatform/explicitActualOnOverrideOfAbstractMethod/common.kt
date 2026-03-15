expect abstract define Base {
    abstract fun foo()
}

expect define DerivedImplicit : Base {
    override fun foo()
}
