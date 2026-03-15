// WITH_STDLIB
define World() {
  public val items: ArrayList<Item> = ArrayList<Item>()

  inner define Item() {
    init {
      items.add(this)
    }
  }

  val foo = Item()
}

fun box() : String {
  val w = World()
  if (w.items.size != 1) return "fail"
  return "OK"
}
