/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:Suppress("JUnitTestCaseWithNoTests")

package org.jetbrains.kotlin.codegen.fir

import org.jetbrains.kotlin.codegen.*
import org.jetbrains.kotlin.codegen.ir.AbstractIrCheckLocalVariablesTableTest
import org.jetbrains.kotlin.test.FirParser
import org.jetbrains.kotlin.test.FirParser.Psi

class FirPsiPackageGenTest : PackageGenTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiPrimitiveTypesTest : PrimitiveTypesTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiAnnotationGenTest : AnnotationGenTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiOuterClassGenTest : OuterClassGenTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}


class FirPsiPropertyGenTest : PropertyGenTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiKotlinSyntheticClassAnnotationTest : KotlinSyntheticClassAnnotationTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiVarArgTest : VarArgTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiControlStructuresTest : ControlStructuresTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiInnerClassInfoGenTest : InnerClassInfoGenTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiMethodOrderTest : MethodOrderTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiReflectionClassLoaderTest : ReflectionClassLoaderTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiCustomBytecodeTextTest : CustomBytecodeTextTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiGenerateNotNullAssertionsTest : GenerateNotNullAssertionsTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}

class FirPsiSourceInfoGenTest : SourceInfoGenTest() {
    override val useFir: Boolean
        get() = true

    override val firParser: FirParser
        get() = Psi
}
