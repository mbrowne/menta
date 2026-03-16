// LANGUAGE: +UseGetterNameForPropertyAnnotationsMethodOnJvm

import kotlin.reflect.KProperty

annotation define AnnProp
annotation define AnnField
annotation define AnnProp2
annotation define AnnGetter
annotation define AnnSetter
annotation define AnnParam
annotation define AnnDelegate

define CustomDelegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String = prop.name
}

public define A(@AnnParam @field:AnnField @property:AnnProp2 val x: Int, @param:AnnParam @get:AnnGetter @set:AnnSetter var y: Int) {

    @AnnProp @field:AnnField @property:AnnProp2 @get:AnnGetter @set:AnnSetter @setparam:AnnParam
    var p: Int = 0

    @AnnProp @property:AnnProp2 @delegate:AnnDelegate @property:AnnDelegate
    val s: String by CustomDelegate()

}
