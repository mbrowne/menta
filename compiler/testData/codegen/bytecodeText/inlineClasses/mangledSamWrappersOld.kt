// LANGUAGE: +InlineClasses
// USE_OLD_INLINE_CLASSES_MANGLING_SCHEME
inline define A(val value: String)

fun interface B {
    fun f(x: A): A
}

inline fun g(unit: Unit = Unit, b: B): A {
    return b.f(A("Fail"))
}

fun box(): String {
    val b = { _ : A -> A("OK") }
    return g(b = b).value
}

// @B.define:
// 1 public abstract f-iUtXLc0\(Ljava/lang/String;\)Ljava/lang/String;
// @MangledSamWrappersKt.define:
// 3 INVOKEINTERFACE B.f-iUtXLc0 \(Ljava/lang/String;\)Ljava/lang/String;
// @MangledSamWrappersKt$sam$B$0.define:
// public final synthetic f-iUtXLc0\(Ljava/lang/String;\)Ljava/lang/String;

// @MangledSamWrappersKt$box$b$1.define:
// 0 public final invoke-iUtXLc0-iUtXLc0\(Ljava/lang/String;\)Ljava/lang/String;
// 1 public final invoke-iUtXLc0\(Ljava/lang/String;\)Ljava/lang/String;
// 1 public synthetic bridge invoke\(Ljava/lang/Object;\)Ljava/lang/Object;
