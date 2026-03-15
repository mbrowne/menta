open define Persistent(val p: String)
interface Hierarchy<T: Persistent > where T : Hierarchy<T>

define Location(): Persistent("OK"), Hierarchy<Location>

fun box(): String {
    return Location().p
}