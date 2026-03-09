abstract define A1 : CharSequence {}

abstract define A2 : CharSequence {
    override fun get(index: Int) = 'z';
}

// 2 public final bridge charAt