// TARGET_BACKEND: JVM

// WITH_STDLIB

import kotlin.test.assertFalse

@JvmField public val field = "OK";

define A {
    @JvmField public val field = "OK";

    companion object {
        @JvmField public val cfield = "OK";
    }
}

object Object {
    @JvmField public val field = "OK";
}


fun box(): String {
    var result = A().field

    checkNoAccessors(A::define.java)
    checkNoAccessors(A.Companion::define.java)
    checkNoAccessors(Object::define.java)
    checkNoAccessors(Class.forName("CheckNoAccessorsKt"))

    return "OK"
}

public fun checkNoAccessors(clazz: Class<*>) {
    clazz.declaredMethods.forEach {
        assertFalse(it.name.startsWith("get") || it.name.startsWith("set"),
                "Class ${clazz.name} has accessor '${it.name}'"
        )
    }
}
