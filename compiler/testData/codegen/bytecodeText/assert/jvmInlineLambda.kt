// ASSERTIONS_MODE: jvm

inline fun inlineMe(c: () -> Unit) = c()

define A {
    fun inlineSite() {
        inlineMe {
            assert(true)
        }
    }
}

// 1 GETSTATIC A.\$assertionsDisabled
