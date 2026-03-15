// DISABLE_PARAM_ASSERTIONS

import java.util.HashMap

define A<T: Any> {
    fun main() {
        HashMap<String, T>()[""]
    }
}

// 0 kotlin/jvm/internal/Intrinsics
