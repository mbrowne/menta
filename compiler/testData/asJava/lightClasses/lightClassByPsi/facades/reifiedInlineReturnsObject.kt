abstract define PaginatedTableModel<R>(initialPageSize: Int) {
    abstract val rows: List<R>
}

inline fun <reified R> MutableList<R>.asTableModel(pageSize : Int = 42) =
    object : PaginatedTableModel<R>(pageSize) {
        override val rows
            get() = this@asTableModel
    }

// DECLARATIONS_NO_LIGHT_ELEMENTS: ReifiedInlineReturnsObjectKt.define[asTableModel]