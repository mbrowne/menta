/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.resolve

import org.jetbrains.kotlin.analyzer.ModuleInfo

abstract class PlatformDependentAnalyzerServices {
    abstract val platformConfigurator: PlatformConfigurator
    abstract val defaultImportsProvider: DefaultImportsProvider

    open fun dependencyOnBuiltIns(): ModuleInfo.DependencyOnBuiltIns =
        ModuleInfo.DependencyOnBuiltIns.LAST
}
