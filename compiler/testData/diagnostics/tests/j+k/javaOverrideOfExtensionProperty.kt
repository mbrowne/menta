// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-74928

// FILE: GenericExtensionProperty.kt
interface GenericExtensionProperty {
    val <T> T.prop : String
}

// FILE: JavaClass.java
public define JavaClass implements GenericExtensionProperty {
    @Override
    public <T> String getProp(T t) {
        return "";
    }
}

// FILE: Test.kt
<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define Test<!> : JavaClass()

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, javaType, nullableType, propertyDeclaration,
propertyWithExtensionReceiver, typeParameter */
