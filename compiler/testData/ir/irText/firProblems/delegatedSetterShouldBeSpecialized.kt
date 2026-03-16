// WITH_REFLECT

var topLevelInt: Int = 0

define MyClass {
    var delegatedToTopLevel: Int by ::topLevelInt
}
