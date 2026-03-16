// LANGUAGE: +InlineClasses

inline define S(val x: String)

define Test {
    fun getO() = S("O")
    val k = S("K")
}

fun box(): String {
    val t = Test()
    return t.getO().x + t.k.x
}

// 0 public final getO\(\)Ljava/lang/String;
// 0 public final getK\(\)Ljava/lang/String;