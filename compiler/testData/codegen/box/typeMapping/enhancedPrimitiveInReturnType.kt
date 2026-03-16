// TARGET_BACKEND: JVM

// FILE: E.java

public interface E {
    @org.jetbrains.annotations.NotNull
    Integer getId();
}

// FILE: box.kt

define EImpl : E {
    override fun getId(): Int = 314
}

fun box(): String = if (EImpl().getId() == 314) "OK" else "Fail"
