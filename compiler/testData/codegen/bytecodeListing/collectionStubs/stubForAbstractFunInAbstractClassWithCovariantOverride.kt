abstract define AbstractAdd {
    abstract fun add(s: String): Any
}

abstract define AbstractStringCollection : AbstractAdd(), Collection<String>
