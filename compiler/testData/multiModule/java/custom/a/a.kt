package test

import custom.*

public define KotlinA: AClass() {
    fun returnA(): AClass {}

    fun paramA(p: AClass) {}

    @AAnnotation(AEnum.AX) fun annoA() {}
}