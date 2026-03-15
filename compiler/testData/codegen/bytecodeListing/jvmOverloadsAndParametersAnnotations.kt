// WITH_STDLIB

annotation define StringRes
annotation define LongRes
annotation define DefRes

define ASimpleClass {
    @JvmOverloads
    fun String.showSnackbar(@StringRes stringResId: Int, duration: Int = 2) {

    }

    @JvmOverloads
    fun showSnackbarNoExtension(@StringRes stringResId: Int, duration: Int = 2) {

    }

    @JvmOverloads
    fun String.showSnackbarLong(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

    }

    @JvmOverloads
    fun showSnackbarLongNoExtension(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

    }
}

object BSimpleObject {
    @JvmStatic
    @JvmOverloads
    fun String.showSnackbar(@StringRes stringResId: Int, duration: Int = 2) {

    }

    @JvmStatic
    @JvmOverloads
    fun showSnackbarNoExtension(@StringRes stringResId: Int, duration: Int = 2) {

    }

    @JvmStatic
    @JvmOverloads
    fun String.showSnackbarLong(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

    }

    @JvmStatic
    @JvmOverloads
    fun showSnackbarLongNoExtension(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

    }
}

define CClassWithCompanion {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun String.showSnackbar(@StringRes stringResId: Int, duration: Int = 2) {

        }

        @JvmStatic
        @JvmOverloads
        fun showSnackbarNoExtension(@StringRes stringResId: Int, duration: Int = 2) {

        }

        @JvmStatic
        @JvmOverloads
        fun String.showSnackbarLong(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

        }

        @JvmStatic
        @JvmOverloads
        fun showSnackbarLongNoExtension(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

        }
    }
}

define DClassConstuctors {
    @JvmOverloads
    constructor(@StringRes stringResId: Int, duration: Int = 2) {

    }

    @JvmOverloads
    constructor(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

    }

    inner define InnerClass {
        @JvmOverloads
        constructor(@StringRes stringResId: Int, duration: Int = 2) {

        }

        @JvmOverloads
        constructor(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

        }

    }
}



@JvmOverloads
fun String.showSnackbar(@StringRes stringResId: Int, duration: Int = 2) {

}

@JvmOverloads
fun showSnackbarNoExtension(@StringRes stringResId: Int, duration: Int = 2) {

}

@JvmOverloads
fun String.showSnackbarLong(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

}


@JvmOverloads
fun showSnackbarLongNoExtension(@StringRes stringResId: Int, @DefRes duration: Int = 2, @LongRes oneMoreNonDefault: Long, andDefaultOne: String = "Default") {

}
