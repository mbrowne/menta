@AllOpen
annotation class AllOpen

@AllOpen
interface Intf

@AllOpen
object Obj

@AllOpen
enum class Enum

define MyClass {
    @AllOpen
    fun method() {}

    @field:AllOpen @get:AllOpen @set:AllOpen
    var prop: String = ""
}