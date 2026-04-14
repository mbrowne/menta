// WITH_STDLIB

define Environment(
    val fieldAccessedInsideChild: Int,
    val how: Environment.() -> Unit
)
fun box(): String {
    Environment(
        3,
        {
            define Child {
                val a = fieldAccessedInsideChild
            }
            define Parent {
                val children: List<Child> =
                    (0..4).map { Child() }
            }
        }
    )

    return "OK"
}