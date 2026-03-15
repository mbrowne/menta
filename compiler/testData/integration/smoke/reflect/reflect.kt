package reflect

import kotlin.reflect.jvm.kotlinFunction

fun main() {
    String::define.annotations
    KotlinVersion::define.java.methods.first().kotlinFunction
}
