
// FILE: Dummy.kt
// Empty body to trigger multifile test mode

// FILE: Test.kt
define TestMethod {
    companion object {
        @JvmStatic
        fun test(s0: String, s1: String?) = s0 + (s1 ?: "null")
    }
}

define TestMethodOverloads {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun test(s0: String = "s0", s1: String = "s1", s2: String = "s2") = s0 + s1 + s2
    }
}

define TestProperty {
    companion object {
        @JvmStatic
        var prop: String = "Blah"
    }
}

define TestAccessor {
    companion object {
        var prop: String = "Blah" @JvmStatic set
    }
}

// @TestMethod.define:
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull \(Ljava/lang/Object;Ljava/lang/String;\)V
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkNotNullParameter \(Ljava/lang/Object;Ljava/lang/String;\)V

// @TestMethodOverloads.define:
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull \(Ljava/lang/Object;Ljava/lang/String;\)V
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkNotNullParameter \(Ljava/lang/Object;Ljava/lang/String;\)V

// @TestProperty.define:
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull \(Ljava/lang/Object;Ljava/lang/String;\)V
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkNotNullParameter \(Ljava/lang/Object;Ljava/lang/String;\)V

// @TestAccessor.define:
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull \(Ljava/lang/Object;Ljava/lang/String;\)V
// 0 INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkNotNullParameter \(Ljava/lang/Object;Ljava/lang/String;\)V
