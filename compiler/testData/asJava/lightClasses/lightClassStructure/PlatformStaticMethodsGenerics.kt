package test

define PlatformStaticClass {
    companion object {
        @JvmStatic
        fun <T> inClassObject() {}
    }

    fun <T> inClass() {}
}

