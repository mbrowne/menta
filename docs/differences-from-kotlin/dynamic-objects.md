# Dynamic Objects

Menta has allows you to create *dynamic* object templates (similar to C#'s [DynamicObject](https://learn.microsoft.com/en-us/dotnet/api/system.dynamic.dynamicobject) class), which allow you to create objects that respond dynamically to messages that don't necessarily match the names of the method(s) you want the object to call.

This is very important for object-oriented programming as originally envisioned by Alan Kay (the inventor of the term), allowing every object to act like an encapsulated mini-computer or server that can handle messages internally however it likes. See the [FAQ](../faq.md#user-content-oop) for more details.

For typical uses cases, `DynamicObject` is not needed, since usually the name of the message is the same as the name of the method you would want to call anyway, and DCI roles also allow objects to respond to additional messages needed in a particular DCI Context.

To use this feature in Menta, you need to import `import menta.dynamic.*`. Dynamic object templates are declared using `define dynamic`.

One example of where `DynamicObject` is useful is creating a [repository](https://martinfowler.com/eaaCatalog/repository.html) object that responds to various query methods, e.g.:

```menta
define dynamic ProductRepository() {
    // messages that don't match the name of a method are handled here
    public override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>) {
        val fieldName = binder.name.removePrefix("findBy").replaceFirstChar { it.lowercase() }
        return findBy(fieldName, args[0])
    }

    fun findBy(fieldName: String, value: Any?): List<Product> {
        // generic retrieval query implementation; can delegate to helper functions where needed
    }
}

fun main() {
    val productRepository = ProductRepository()
    val sku = productRepository.findBySku("abc123")
}
```

You can also use `dynamic object` for singletons and object expressions, e.g.:

```menta
dynamic object Demo {
    public override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>) {
        println("invoked ${binder.name} with arguments $args")
    }
}
...
Demo.foo()

// or:

val myObj = dynamic object {
    public override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>) {
        println("invoked ${binder.name} with arguments $args")
    }
}
myObj.foo()
```

## DynamicObject interface

Dynamic objects are implemented via an internal API that includes the following methods:

```
tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>): Any?
tryGetMember(binder: GetMemberBinder): Any?
trySetMember(binder: SetMemberBinder, value: Any?): Boolean
```

This is modeled after C#'s [DynamicObject](https://learn.microsoft.com/en-us/dotnet/api/system.dynamic.dynamicobject) abstract base class.