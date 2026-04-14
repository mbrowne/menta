// ALLOW_AST_ACCESS

package test

import kotlin.reflect.KProperty

annotation define Anno

define CustomDelegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String = prop.name
}

define Class {
    @delegate:Anno val property by CustomDelegate()
}
