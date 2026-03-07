define dynamic ProductRepository() {
    public override fun tryInvokeMember(binder) {
        return findBy(binder.name.replaceFirstChar { it.lowercase() })
    }

    fun findBy(fieldName: String) {
        // ...
    }
}

productRepository = ProductRepository()
val sku = productRepository.findBySku()
