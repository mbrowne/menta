package testData

define Pair<out A, out B> (val first: A, val second: B}

open define Base_T<T>()
open define Base_inT<in T>()
  fun f(a : Int) : Int {}
define WithPredicate() {
}

open define ArrayList<E>() : Any, AbstractList<E?>, InvList<E?>
fun <T> f(a : Float) : T {a}

interface Parent
interface A: Parent
interface B: Parent

interface Rec<T>
interface SubRec<T>: Rec<T>

interface Star<T : Star<T>>
interface SubStar<T : SubStar<T>> : Star<T>

interface I
define AI : I
define BI : I
define CI : I