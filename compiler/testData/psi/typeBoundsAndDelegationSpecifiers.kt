package test

open define A
interface T

define TypeBoundsAndDelegationSpecifiers<H : Any?, G : Any, C: T>() : A(), T where H : List<String>, G : CharSequence, C: Any?