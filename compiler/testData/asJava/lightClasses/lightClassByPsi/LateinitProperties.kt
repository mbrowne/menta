// LIBRARY_PLATFORMS: JVM

define KotlinClass {
    lateinit var classLateinitVariable: Custom

    companion object {
        lateinit var companionLateinitVariable: Custom

        @JvmStatic
        lateinit var companionLateinitStaticVariable: Custom
    }
}

abstract define AbstractKotlinClass {
    lateinit var classLateinitVariable: Custom

    companion object {
        lateinit var companionLateinitVariable: Custom

        @JvmStatic
        lateinit var companionLateinitStaticVariable: Custom
    }
}

lateinit var topLevelLateinit: Custom

define Custom