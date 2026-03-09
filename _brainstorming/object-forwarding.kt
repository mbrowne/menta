interface Named {
    val name: String
}

define Animal(override val name: String): Named {}

// should have a more concise syntax for this:
define Cat(override val name: String, animal: Named = Animal(name)): Named by animal {}

// perhaps:
define Cat(val name: String): Named by animal {
    // question: would this be any different than Kotlin's existing init {} construct?
    new {
        animal = Animal(name)
        return this
    }
}

val cat = Cat("Garfield")

fun main() {
    println(cat.name)
}

// ...

// Interfaces from public `define` members:

interface IAnimal from Animal

// Alternative:

define Animal(override val name: String): Named {}

define CatDef(animal: Animal): Animal by animal {
    fun meow() = println("meow")
}

fun Cat(name: String): CatDef = CatDef(Animal(name))

// (Adapted) suggestion from Gemini, based on my idea of
// "limiting the language to one class delegate and N interface delegates"
/*
interface ICamera from Camera
define Camera {
    fun takePhoto() {}
}
define SmartCamera(val hardware: ICamera) : parent ICamera by hardware {
    // SmartCamera now "is a" Camera. 
    // Any call to SmartCamera.takePhoto() goes to 'hardware'.
}

// Note: if we wanted to make the naming extra clear, we could name it 'parenttype' instead
// of 'parent' since it's really just for the type system.
//
// Question: do we even need a 'parent' at all? Kotlin already allows you to extend from
// nothing but interfaces (e.g. multiple interfaces, no classes) - should check how this currently works.

// This would be an error, since there can only be one parent :
interface IFoo from Foo
define Foo {}
define SmartCamera(val hardware: Camera, val foo: IFoo) : parent Camera by hardware, parentType IFoo by foo {
*/

// Question: how to handle more complex init? e.g.:
/*
define SmartCamera(val hardware?: ICamera) : parent ICamera by hardware {
    init {
        if (hardware == null) {
            hardware = Camera(...)
        }
    }
}
*/

private fun initCamera(name: String): ICamera {
    return Camera(...)
}

define SmartCamera(val name: String, private val hardware: ICamera = initCamera(name)) : ICamera by hardware {}
