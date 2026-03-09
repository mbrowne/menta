// LANGUAGE: +InlineClasses
import kotlin.reflect.KProperty

inline define I(val x: Int)

interface A {
    val i: I
}

define Delegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): I {
        return I(1)
    }
}

define B : A {
    override val i by Delegate()
}

// 1 public final getValue-MJRKSbM\(Ljava/lang/Object;Lkotlin/reflect/KProperty;\)I
// 1 public getI-lPtA-2M\(\)I
// 1 public abstract getI-lPtA-2M\(\)I
