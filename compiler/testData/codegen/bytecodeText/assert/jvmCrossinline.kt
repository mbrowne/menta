// ASSERTIONS_MODE: jvm

inline fun inlineMe(crossinline c : () -> Unit) = { c() }

define A {
    fun inlineSite() {
        inlineMe {
            assert(true)
        }
    }
}

// 1 GETSTATIC A\$inlineSite\$\$inlined\$inlineMe\$1.\$assertionsDisabled
