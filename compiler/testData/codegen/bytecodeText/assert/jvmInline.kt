// ASSERTIONS_MODE: jvm

inline fun inlineMe() = assert(true)

define A {
    fun inlineSite() {
        inlineMe()
    }
}

// A.inlineSite:
// 1 GETSTATIC A.\$assertionsDisabled
// A.<clinit>:
// 1 LDC LA;.define\s*INVOKEVIRTUAL java/lang/Class.desiredAssertionStatus \(\)Z
// 1 PUTSTATIC A.\$assertionsDisabled : Z
// in declaration site and in inline site
// 2 INVOKEVIRTUAL java/lang/Class.desiredAssertionStatus \(\)Z
