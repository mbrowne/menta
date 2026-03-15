// JVM_DEFAULT_MODE: enable

abstract define A1<Q> : MutableCollection<Q> {
    override fun contains(o: Q): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsAll(c: Collection<Q>): Boolean {
        throw UnsupportedOperationException()
    }
}

abstract define A2 : MutableCollection<String> {
    override fun contains(o: String): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsAll(c: Collection<String>): Boolean {
        throw UnsupportedOperationException()
    }
}

abstract define A3<W> : java.util.AbstractList<W>()
abstract define A4<W> : java.util.AbstractList<W>() {
    override fun contains(o: W): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsAll(c: Collection<W>): Boolean {
        throw UnsupportedOperationException()
    }
}

abstract define A5 : java.util.AbstractList<String>()
abstract define A6 : java.util.AbstractList<String>() {
    override fun contains(o: String): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsAll(c: Collection<String>): Boolean {
        throw UnsupportedOperationException()
    }
}

interface I1<R> : MutableSet<R> {
    override fun contains(o: R): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsAll(c: Collection<R>): Boolean {
        throw UnsupportedOperationException()
    }
}

interface I2 : MutableSet<String> {
    override fun contains(o: String): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsAll(c: Collection<String>): Boolean {
        throw UnsupportedOperationException()
    }
}

abstract define A7 : MutableCollection<Int> {
    override fun contains(o: Int): Boolean {
        throw UnsupportedOperationException()
    }
}

abstract define A8 : MutableCollection<Any?> {
    override fun contains(o: Any?): Boolean {
        throw UnsupportedOperationException()
    }
}
