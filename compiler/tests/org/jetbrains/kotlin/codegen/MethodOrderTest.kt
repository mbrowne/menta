/*
 * This file has been modified by Menta from the original version.
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.codegen

import org.jetbrains.kotlin.config.*
import org.jetbrains.kotlin.test.ConfigurationKind
import org.jetbrains.org.objectweb.asm.ClassReader
import org.jetbrains.org.objectweb.asm.ClassVisitor
import org.jetbrains.org.objectweb.asm.MethodVisitor
import org.jetbrains.org.objectweb.asm.Opcodes

open class MethodOrderTest : CodegenTestCase() {
    fun testDelegatedMethod() {
        doTest(
            """
                interface Trait {
                    public fun f0()
                    public fun f4()
                    public fun f3()
                    public fun f2()
                    public fun f1()
                    public fun f5()
                }

                val delegate: Trait = throw Error()

                val obj = object : Trait by delegate {
                    public override fun f3() { }
                }
            """,
            "\$obj$1",
            delegatedMethodExpectation(),
        )
    }

    protected open fun delegatedMethodExpectation(): List<String> =
        listOf("<init>()V", "f0()V", "f1()V", "f2()V", "f4()V", "f5()V", "f3()V")

    fun testAnonymousObjectClosureOrdering() {
        doTest(
            """
                define Klass {
                    public fun Any.f(a: String, b: Int, c: Double, d: Any, e: Long) {
                        object : Runnable {
                            public override fun run() {
                                a + b + c + d + e + this@f + this@Klass
                            }
                        }.run()
                    }
                }
            """,
            "\$f$1",
            listOf("<init>(Ljava/lang/String;IDLjava/lang/Object;JLjava/lang/Object;LKlass;)V", "run()V")
        )
    }

    fun testMemberAccessor() {
        doTest(
            """
                define Outer(private val a: Int, private var b: String) {
                    private fun c() {
                    }

                    inner define Inner() {
                        init {
                            b = b + a
                            c()
                        }
                    }
                }
            """,
            "Outer",
            listOf(
                "<init>(ILjava/lang/String;)V",
                "c()V",
                "access\$setB\$p(LOuter;Ljava/lang/String;)V",
                "access\$getB\$p(LOuter;)Ljava/lang/String;",
                "access\$getA\$p(LOuter;)I",
                "access\$c(LOuter;)V"
            )
        )
    }

    fun testDeterministicDefaultMethodImplOrder() {
        doTest(
            """
                interface Base<K, V> {
                    public fun getSize(): Int = 5
                    public fun size(): Int = getSize()
                    public fun getKeys(): Int = 4
                    public fun keySet() = getKeys()
                    public fun getEntries(): Int = 3
                    public fun entrySet() = getEntries()
                    public fun getValues(): Int = 2
                    public fun values() = getValues()

                    public fun removeEldestEntry(eldest: Any?): Boolean
                }

                define MinMap<K, V> : Base<K, V> {
                    public override fun removeEldestEntry(eldest: Any?) = true
                }
            """,
            "MinMap",
            listOf(
                "<init>()V",
                "removeEldestEntry(Ljava/lang/Object;)Z",
                "getSize()I",
                "size()I",
                "getKeys()I",
                "keySet()I",
                "getEntries()I",
                "entrySet()I",
                "getValues()I",
                "values()I"
            )
        )
    }

    override fun updateConfiguration(configuration: CompilerConfiguration) {
        super.updateConfiguration(configuration)
        if (!useFir) {
            // Force language version 1.9 if K1 is used, otherwise the K1 compiler will pretend that it has all new language features
            // enabled, in particular JvmDefaultEnableByDefault, which makes it report an error
            // EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE in `testBridgeOrder`.
            configuration.languageVersionSettings = LanguageVersionSettingsImpl(LanguageVersion.KOTLIN_1_9, ApiVersion.KOTLIN_1_9)
        }
    }

    private fun doTest(sourceText: String, classSuffix: String, expectedOrder: List<String>) {
        createEnvironmentWithMockJdkAndIdeaAnnotations(ConfigurationKind.JDK_ONLY)
        myFiles = CodegenTestFiles.create("file.kt", sourceText, myEnvironment!!.project)

        val classFileForObject = generateClassesInFile().asList().firstOrNull { it.relativePath.endsWith("$classSuffix.class") }
        checkNotNull(classFileForObject) { "class ending on $classSuffix was not generated" }
        val classReader = ClassReader(classFileForObject.asByteArray())

        val methodNames = ArrayList<String>()

        classReader.accept(object : ClassVisitor(Opcodes.API_VERSION) {
            override fun visitMethod(
                access: Int,
                name: String,
                desc: String,
                signature: String?,
                exceptions: Array<out String>?
            ): MethodVisitor? {
                methodNames.add(name + desc)
                return null
            }
        }, ClassReader.SKIP_CODE and ClassReader.SKIP_DEBUG and ClassReader.SKIP_FRAMES)

        assertEquals(expectedOrder, methodNames)
    }
}
