// TwoOverrides
define TwoOverrides : Iterable<String> {
    override fun iterator() = null

    override fun iterator() = null
}
