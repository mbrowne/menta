[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

# Menta Programming Language

> Note: Menta is currently experimental, and is not yet recommended for use in production.

## What is Menta?

Menta is a multi-platform language originally forked from [Kotlin](https://github.com/JetBrains/kotlin).

It supports multiple paradigms, including functional programming, DCI ([Data, Context and Interaction](https://fulloo.info/)), and object-oriented programming using composition. It deliberately does *not* support traditional classes and inheritance.

## Online Demo

https://codesandbox.io/p/devbox/menta-demo-54hjfz

## Why Menta?

Menta is short for "mental models". The concept of mental models in software traces back at least to [Doug Englebart](https://www.dougengelbart.org/), an early pioneer in the computing field who envisioned the computer as an extension of the human mind (or to use Engelbart's terminology, "augmenting human intellect"). This vision heavily influenced [Alan Kay](https://en.wikipedia.org/wiki/Alan_Kay) and other researchers in the early days of developing GUIs and the precursors of modern personal computers. [1]

In many software contexts today, the original focus on mental models has been largely lost, with concepts such as object orientation or Model-View-Controller explained in merely technical terms. This misses the whole point: Kay's contributions to the technical details of Smalltalk and object orientation pale in comparison to the importance of his research on psychological and user experience principles, a legacy carried on by other researchers to this day. These principles are always relevant to software used by human beings, even if the code is not remotely object-oriented. Still, object orientation (which isn't a great name for it, by Kay's own admission) is a powerful tool for reflecting mental models, which has unfortunately been greatly misunderstood.

### Data, Context, and Interaction

One of the key reasons why Menta was created was to provide first-class support for the [Data, Context and Interaction](https://fulloo.info/) programming paradigm (DCI). DCI, invented by [Trygve Reenskaug](https://en.wikipedia.org/wiki/Trygve_Reenskaug) and refined with the help of collaborator [James Coplien](https://en.wikipedia.org/wiki/Jim_Coplien), helps remind us of the original vision of mental models and object orientation, and also addresses some key areas where it fell short. These shortcomings contributed to widespread frustrations with so-called object orientation as it was applied in the industry, and many valid criticisms of it at a technical level.

Thanks to DCI, we are no longer confined to coupling data and behavior together in a compile-time class hierarchy: we can merge the two dynamically at run-time according to the use cases. DCI also plays well with functional programming and immutable data structures.

### Programming Mental Models

There are many benefits of going back to the historical roots of modeling, writing code that better reflects the mental models of the people using it, the programmers writing it, and other stakeholders—even in the age of AI coding agents. The key concept for us as software engineers is code comprehension: when the code is aligned with mental models that we understand and which serve the needs of users, the result is more user-friendly and maintainable software. And a great thing about programming with this philosophy is that it can apply to any mental model. We usually want to emphasize the end user's mental model first and foremost, but DCI can be used at multiple levels, including some levels which emphasize the programmer's mental model, or a blend between the users' and programmers' models shaped by discussions and shared understanding with the users and stakeholders.

---
[1] Kay's conception of mental models was also informed by the work of Jean Piaget and other psychologists who studied child psychology, as explained in Kay's 1987 presentation [Doing With Images Makes Symbols](https://www.youtube.com/watch?v=p2LZLYcu_JY).

See also the article [Relearning OOP](https://medium.com/@egonelbre/relearning-oop-89f10e0e2f68) by Egon Elbre for a good introduction.

## Documentation

* [Differences from Kotlin](docs/differences-from-kotlin/readme.md)
* [Frequently Asked Questions](docs/faq.md)
* [Code examples](docs/examples)

## Build environment requirements

This repository is using [Gradle toolchains](https://docs.gradle.org/current/userguide/toolchains.html) feature
to select and auto-provision required JDKs from [Eclipse Adoptium](https://adoptium.net) project.

Alternatively, it is still possible to only provide required JDKs via environment variables 
(see [gradle.properties](./gradle.properties#L5) for supported variable names). To ensure Gradle uses only JDKs 
from environmental variables - disable Gradle toolchain auto-detection by passing `-Porg.gradle.java.installations.auto-detect=false` option
(or put it into `$GRADLE_USER_HOME/gradle.properties`).

On Windows you might need to add long paths setting to the repo:

    git config core.longpaths true 

## Building

The project is built with Gradle. Run Gradle to build the project and to run the tests 
using the following command on Unix/macOS:

    ./gradlew <tasks-and-options>
    
or the following command on Windows:

    gradlew <tasks-and-options>

On the first project configuration gradle will download and setup the dependencies on:

* `intellij-core` is a part of command line compiler and contains only necessary APIs.
* `idea-full` is a full blown IntelliJ IDEA Community Edition to be used in the plugin module.

These dependencies are quite large, so depending on the quality of your internet connection 
you might face timeouts getting them. In this case, you can increase timeout by specifying the following 
command line parameters on the first run: 
    
    ./gradlew -Dhttp.socketTimeout=60000 -Dhttp.connectionTimeout=60000

## Important gradle tasks

- `clean` - clean build results
- `dist` - assembles the compiler distribution into `dist/mentac/` folder
- `install` - build and install all public artifacts into local maven repository
- `coreLibsTest` - build and run stdlib, reflect and menta-test tests
- `gradlePluginTest` - build and run gradle plugin tests
- `compilerTest` - build and run all compiler tests

To reproduce TeamCity build use `-Pteamcity=true` flag. Local builds don't run proguard and have jar compression disabled by default.

**OPTIONAL:** Some artifacts, mainly Maven plugin ones, are built separately with Maven.
Refer to [libraries/ReadMe.md](libraries/ReadMe.md) for details.

# TODO

kotlin-native needs to be renamed to menta-native

---

To build Menta/Native, see
[menta-native/README.md](menta-native/README.md#building-from-source).

## <a name="working-in-idea"></a> Working with the project in IntelliJ IDEA

It is recommended to use the latest released version of Intellij IDEA (Community or Ultimate Edition). You can download IntelliJ IDEA [here](https://www.jetbrains.com/idea/download).

After cloning the project, import the project in IntelliJ by choosing the project directory in the Open project dialog.

For handy work with compiler tests it's recommended to use [Kotlin Compiler Test Helper](https://github.com/demiurg906/test-data-helper-plugin).

### Dependency verification

We have a [dependencies verification](https://docs.gradle.org/current/userguide/dependency_verification.html) feature enabled in the
repository for all Gradle builds. Gradle will check hashes (md5 and sha256) of used dependencies and will fail builds with
`Dependency verification failed` errors when local artifacts are absent or have different hashes listed in the
[verification-metadata.xml](https://github.com/JetBrains/kotlin/blob/master/gradle/verification-metadata.xml) file.

It's expected that `verification-metadata.xml` should only be updated with the commits that modify the build. There are some tips how
to perform such updates:

- Delete `components` section of `verification-metadata.xml` to avoid stockpiling of old unused dependencies. You may use the following command:
```bash
#macOS
sed -i '' -e '/<components>/,/<\/components>/d' gradle/verification-metadata.xml
#Linux & Git for Windows
sed -i -e '/<components>/,/<\/components>/d' gradle/verification-metadata.xml
```
- Re-generate dependencies with Gradle's `--write-verification-metadata` command (verify update relates to your changes)

```bash
./gradlew --write-verification-metadata sha256,md5 -Pkotlin.native.enabled=true resolveDependencies
```

*`resolveDependencies` task resolves dependencies for all platforms including dependencies downloaded by plugins.*

You can also use `./scripts/update-verification-metadata.sh` script which includes both of these steps

Keep in mind:

- If you’re adding a dependency with OS mentioned in an artifact name (`darwin`, `mac`, `osx`, `linux`, `windows`), remember to add them to 
  `implicitDependencies` configuration or update `resolveDependencies` task if needed. `resolveDependencies` should resolve all dependencies
  including dependencies for different platforms.
- If you have a `local.properties` file in your Menta project folder, make sure that it doesn't contain `kotlin.native.enabled=false`.
  Otherwise, native-only dependencies may not be added to the verification metadata. This is because `local.properties` has higher 
  precedence than the `-Pkotlin.native.enabled=true` specified in the Gradle command.

# License

Menta is distributed under the terms of the Apache License (Version 2.0). See [license folder](license/README.md) for details.
