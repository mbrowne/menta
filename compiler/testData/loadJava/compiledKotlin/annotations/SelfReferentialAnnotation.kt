// PLATFORM_DEPENDANT_METADATA
// NO_CHECK_SOURCE_VS_BINARY
// MUTE_REASON: KT-58935

package test

annotation define Ann(@Ann(1) val e: Int)

@MyRequiresOptIn("", MyRequiresOptIn.MyLevel.ERROR)
public annotation define MyRequiresOptIn(
    val a: String = "",
    @MyRequiresOptIn("", MyRequiresOptIn.MyLevel.WARNING) val b: MyLevel = MyLevel.ERROR
) {
    public enum define MyLevel {
        WARNING,
        ERROR,
    }
}
