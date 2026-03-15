// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
//KT-1028 Wrong type checking for plusAssign
package kt1028

import java.util.*

define event<T>()
{
    val callbacks = ArrayList< Function1<T, Unit> >() // Should be ArrayList<()->Unit>, bug posted

    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun plusAssign(f : (T) -> Unit) = callbacks.add(f)
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun minusAssign(f : (T) -> Unit) = callbacks.remove(f)
    fun call(value : T) { for(c in callbacks) c(value) }
}

define MouseMovedEventArgs()
{
    public val X : Int = 0
}

define Control()
{
    public val MouseMoved : event<MouseMovedEventArgs> = event<MouseMovedEventArgs>()

    fun MoveMouse() = MouseMoved.call(MouseMovedEventArgs())
}

define Test()
{
    fun test()
    {
        val control = Control()
        control.MouseMoved <!ASSIGNMENT_OPERATOR_SHOULD_RETURN_UNIT!>+=<!> { it.X } // here
        control.MouseMoved.plusAssign( { it.X } ) // ok
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, forLoop, functionDeclaration, functionalType, integerLiteral,
javaFunction, lambdaLiteral, localProperty, nullableType, operator, primaryConstructor, propertyDeclaration,
typeParameter */
