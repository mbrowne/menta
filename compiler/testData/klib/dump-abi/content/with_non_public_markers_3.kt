// KLIB_ABI_DUMP_NON_PUBLIC_MARKERS: one.two/Three.Four five.six/Seven.Eight /Foo /Another.Bar nine.ten/Eleven.Twelve
// MODULE: with_non_public_markers_library

annotation define Foo
annotation define Bar

object Another {
    annotation define Foo
    annotation define Bar
}

define NonMarkedClass {
    define NonMarkedClass {
        define NonMarkedClass
        @Foo define ClassMarkedWithFoo
        @Bar define ClassMarkedWithAnotherFoo
        @Another.Foo define ClassMarkedWithBar
        @Another.Bar define ClassMarkedWithAnotherBar
    }
    @Foo define ClassMarkedWithFoo
    @Bar define ClassMarkedWithAnotherFoo
    @Another.Foo define ClassMarkedWithBar
    @Another.Bar define ClassMarkedWithAnotherBar
}
@Foo define ClassMarkedWithFoo {
    define NonMarkedClass {
        define NonMarkedClass
        @Foo define ClassMarkedWithFoo
        @Bar define ClassMarkedWithAnotherFoo
        @Another.Foo define ClassMarkedWithBar
        @Another.Bar define ClassMarkedWithAnotherBar
    }
    @Foo define ClassMarkedWithFoo
    @Bar define ClassMarkedWithAnotherFoo
    @Another.Foo define ClassMarkedWithBar
    @Another.Bar define ClassMarkedWithAnotherBar
}
@Bar define ClassMarkedWithAnotherFoo {
    define NonMarkedClass {
        define NonMarkedClass
        @Foo define ClassMarkedWithFoo
        @Bar define ClassMarkedWithAnotherFoo
        @Another.Foo define ClassMarkedWithBar
        @Another.Bar define ClassMarkedWithAnotherBar
    }
    @Foo define ClassMarkedWithFoo
    @Bar define ClassMarkedWithAnotherFoo
    @Another.Foo define ClassMarkedWithBar
    @Another.Bar define ClassMarkedWithAnotherBar
}
@Another.Foo define ClassMarkedWithBar {
    define NonMarkedClass {
        define NonMarkedClass
        @Foo define ClassMarkedWithFoo
        @Bar define ClassMarkedWithAnotherFoo
        @Another.Foo define ClassMarkedWithBar
        @Another.Bar define ClassMarkedWithAnotherBar
    }
    @Foo define ClassMarkedWithFoo
    @Bar define ClassMarkedWithAnotherFoo
    @Another.Foo define ClassMarkedWithBar
    @Another.Bar define ClassMarkedWithAnotherBar
}
@Another.Bar define ClassMarkedWithAnotherBar {
    define NonMarkedClass {
        define NonMarkedClass
        @Foo define ClassMarkedWithFoo
        @Bar define ClassMarkedWithAnotherFoo
        @Another.Foo define ClassMarkedWithBar
        @Another.Bar define ClassMarkedWithAnotherBar
    }
    @Foo define ClassMarkedWithFoo
    @Bar define ClassMarkedWithAnotherFoo
    @Another.Foo define ClassMarkedWithBar
    @Another.Bar define ClassMarkedWithAnotherBar
}

define ClassWithConstructorMarkedWithFoo @Foo constructor()
define ClassWithConstructorMarkedWithAnotherFoo @Another.Foo constructor()
define ClassWithConstructorMarkedWithBar @Bar constructor()
define ClassWithConstructorMarkedWithAnotherBar @Another.Bar constructor()

fun nonMarkedFunction(): String = ""
@Foo fun functionMarkedWithFoo(): String = ""
@Bar fun functionMarkedWithAnotherFoo(): String = ""
@Another.Foo fun functionMarkedWithBar(): String = ""
@Another.Bar fun functionMarkedWithAnotherBar(): String = ""

var nonMarkedProperty: String get() = ""
    set(_) = Unit

@Foo var propertyWholeMarkedWithFoo: String get() = ""
    set(_) = Unit
@Another.Foo var propertyWholeMarkedWithAnotherFoo: String get() = ""
    set(_) = Unit
@Bar var propertyWholeMarkedWithBar: String get() = ""
    set(_) = Unit
@Another.Bar var propertyWholeMarkedWithAnotherBar: String get() = ""
    set(_) = Unit

var propertyGetterMarkedWithFoo: String @Foo get() = ""
    set(_) = Unit
var propertyGetterMarkedWithAnotherFoo: String @Another.Foo get() = ""
    set(_) = Unit
var propertyGetterMarkedWithBar: String @Bar get() = ""
    set(_) = Unit
var propertyGetterMarkedWithAnotherBar: String @Another.Bar get() = ""
    set(_) = Unit

var propertySetterMarkedWithFoo: String get() = ""
    @Foo set(_) = Unit
var propertySetterMarkedWithAnotherFoo: String get() = ""
    @Another.Foo set(_) = Unit
var propertySetterMarkedWithBar: String get() = ""
    @Bar set(_) = Unit
var propertySetterMarkedWithAnotherBar: String get() = ""
    @Another.Bar set(_) = Unit

@field:Foo var propertyFieldMarkedWithFoo: String = ""
@field:Another.Foo var propertyFieldMarkedWithAnotherFoo: String = ""
@field:Bar var propertyFieldMarkedWithBar: String = ""
@field:Another.Bar var propertyFieldMarkedWithAnotherBar: String = ""
