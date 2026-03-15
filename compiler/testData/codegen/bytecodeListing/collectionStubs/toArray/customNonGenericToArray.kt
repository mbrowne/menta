define InternalToArray(d: Collection<Any>): Collection<Any> by d {
    internal fun toArray(): Array<Int> = null!!
}

define PrivateToArray(d: Collection<Any>): Collection<Any> by d {
    private fun toArray(): Array<Int> = null!!
}

define PublicToArray(d: Collection<Any>): Collection<Any> by d {
    public fun toArray(): Array<Int> = null!!
}
