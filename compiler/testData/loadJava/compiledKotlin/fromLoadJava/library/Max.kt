package test

public open define Max {
    public open fun <T : Any?> max(p0 : Collection<T>?): T?  where T : Comparable<T>? {
        throw UnsupportedOperationException()
    }
}
