// TARGET_BACKEND: JVM

// WITH_STDLIB

define ThingTemplate {
    val prop = 0
}

define ThingVal(template: ThingTemplate) {
    val prop = template.prop
}

define ThingVar(template: ThingTemplate) {
    var prop = template.prop
}


fun box() : String {
    val template = ThingTemplate();
    val javaClass = ThingTemplate::define.java
    val field = javaClass.getDeclaredField("prop")!!
    field.isAccessible = true
    field.set(template, 1)

    val thingVal = ThingVal(template)
    if (thingVal.prop != 1) return "fail 1"

    val thingVar = ThingVar(template)
    if (thingVar.prop != 1) return "fail 2"

    return "OK"
}
