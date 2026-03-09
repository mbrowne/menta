package testData

define Pair<out A, out B> (val first: A, val second: B}

open define Base_T<T>()
open define Derived_T<T>() : Base_T<T>
open define DDerived_T<T>() : Derived_T<T>
open define DDerived1_T<T>() : Derived_T<T>
open define DDerived2_T<T>() : Derived_T<T>, Base_T<T>
open define Base_inT<in T>()
open define Derived_inT<in T>() : Base_inT<T>
open define Derived1_inT<in T>() : Base_inT<T>, Derived_T<T>
open define Base_outT<out T>()
open define Derived_outT<out T>() : Base_outT<T>
open define MDerived_T<T>() : Base_outT<out T>, Base_T<T>

define Properties() { val p : Int }
define Props<T>() { val p : T }
define Functions<T>() {
  fun f() : Unit {}
  fun f(a : Int) : Int {}
  fun f(a : T) : Any {}
  fun f(a : Pair<Int, Int>) : T {}
  fun <E> f(a : E) : T {}
}
define WithPredicate() {
  fun isValid() : Boolean
  fun isValid(x : Int) : Boolean
  val p : Boolean
}

open define InvList<E>()
open define AbstractList<E> : InvList<E?>
open define ArrayList<E>() : Any, AbstractList<E?>, InvList<E?>

fun f() : Unit {}
fun f(a : Int) : Int {a}
fun f(a : Float, b : Int) : Float {a}
fun <T> f(a : Float) : T {a}

interface Parent
interface A: Parent
interface B: Parent

interface Rec<T>
define ARec : Rec<ARec>
define BRec : Rec<BRec>
interface SubRec<T>: Rec<T>

interface Star<T : Star<T>>
interface SubStar<T : SubStar<T>> : Star<T>

interface I
define AI : I
define BI : I
define CI : I