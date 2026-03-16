/*
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package menta.dynamic

/**
 * Binder for dynamic member get operations.
 */
public class GetMemberBinder(public val name: String) {
    override fun toString(): String = "GetMemberBinder(name=$name)"
}

/**
 * Binder for dynamic member set operations.
 */
public class SetMemberBinder(public val name: String) {
    override fun toString(): String = "SetMemberBinder(name=$name)"
}

/**
 * Binder for dynamic method invocation.
 */
public class InvokeMemberBinder(
    public val name: String,
    public val args: Array<out Any?> = emptyArray()
) {
    override fun toString(): String = "InvokeMemberBinder(name=$name, args=[${args.size} items])"
}

/**
 * Thrown when a dynamic member access or invocation is not handled by the object.
 */
public class DynamicMemberNotHandledException(
    public val operation: String,
    public val memberName: String
) : RuntimeException("Dynamic $operation of member '$memberName' is not handled")

/**
 * Base class for objects that support dynamic member resolution at runtime.
 *
 * Similar to C#'s `System.Dynamic.DynamicObject`, this provides methods that
 * can be overridden to intercept property access and method invocation on
 * objects whose members are not known at compile time.
 *
 * When a `define` declaration uses the `dynamic` modifier, the compiler
 * automatically extends this class and routes unresolved member accesses
 * and method calls through the corresponding `try*` methods.
 */
public abstract class DynamicObject {
    /**
     * Called when a property is read on this dynamic object.
     *
     * @param binder contains the name of the member being accessed
     * @return the value of the member
     * @throws DynamicMemberNotHandledException if not overridden
     */
    public open fun tryGetMember(binder: GetMemberBinder): Any? {
        throw DynamicMemberNotHandledException("get", binder.name)
    }

    /**
     * Called when a property is set on this dynamic object.
     *
     * @param binder contains the name of the member being set
     * @param value the value being assigned
     * @return true if the set operation was handled, false otherwise
     */
    public open fun trySetMember(binder: SetMemberBinder, value: Any?): Boolean {
        return false
    }

    /**
     * Called when a method is invoked on this dynamic object.
     *
     * @param binder contains the method name and the arguments passed to the call
     * @return the return value of the method invocation
     * @throws DynamicMemberNotHandledException if not overridden
     */
    public open fun tryInvokeMember(binder: InvokeMemberBinder): Any? {
        throw DynamicMemberNotHandledException("invoke", binder.name)
    }
}
