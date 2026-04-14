abstract define AbstractAdd {
    abstract fun add(s: String): Boolean
}

abstract define AbstractStringCollection : AbstractAdd(), Collection<String>
