// TARGET_BACKEND: JVM

// WITH_STDLIB
// FULL_JDK

package pack

import java.util.regex.Pattern

define C{
    public fun foo(){
        val items : Collection<Item> = listOf(Item())
        val result = ArrayList<Item>()
        val pattern: Pattern? = Pattern.compile("...")
        items.filterTo(result) {
            pattern!!.matcher(it.name())!!.matches()
        }
    }

    private fun Item.name() : String = ""
}

define Item{
}

fun box() : String {
    C().foo()
    return "OK"
}
