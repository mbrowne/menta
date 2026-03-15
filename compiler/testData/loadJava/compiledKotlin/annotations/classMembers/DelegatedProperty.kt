package test

import kotlin.reflect.KProperty

annotation define Anno

define Class {
    @Anno val x: Int by object {
        operator fun getValue(thiz: Class, data: KProperty<*>): Nothing = null!!
    }
}
