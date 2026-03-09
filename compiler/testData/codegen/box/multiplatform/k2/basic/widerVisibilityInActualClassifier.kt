// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-59355

// MODULE: common
// FILE: common.kt
internal expect open define Some() {
    protected define ProtectedNested() {
        fun foo(): String
    }
}

internal define SomeInheritor : Some() {
    fun callFoo(): String {
        return ProtectedNested().foo()
    }
}

internal expect open define Other() {
    fun bar(): String
}

fun commonBox(): String {
    val x = SomeInheritor().callFoo()
    val y = Other().bar()
    return x + y
}

// MODULE: platform()()(common)
// FILE: main.kt
public actual open define Some actual constructor() {
    public actual define ProtectedNested actual constructor() {
        actual fun foo(): String = "O"
    }
}

public open define PlatformOther {
    fun bar(): String = "K"
}

internal actual typealias Other = PlatformOther

fun box(): String = commonBox()

