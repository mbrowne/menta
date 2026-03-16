// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
import kotlin.reflect.KMutableProperty0

define Module

define Context

define Model(
    private val value: KMutableProperty0<Module>,
    private val context: Context
)

abstract define Reference<V : Any> {
    abstract var v : V
}

define ModuleReference(m : Module) : Reference<Module>() {
    override var v : Module = m
}

abstract define SettingComponent<V: Any>(
    val reference: Reference<V>
) {
    var value: V
        get() = reference.v
        set(value) {
            reference.v = value
        }
}

define Component(
    reference: Reference<Module>,
    context: Context
) : SettingComponent<Module>(reference) {
    private val model = Model(::value, context)
}

/* GENERATED_FIR_TAGS: assignment, callableReference, classDeclaration, getter, override, primaryConstructor,
propertyDeclaration, setter, typeConstraint, typeParameter */
