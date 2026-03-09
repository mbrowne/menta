define User(public val name: String) {}

fun MyContext {
    role R {
    } requires readonly User
}
