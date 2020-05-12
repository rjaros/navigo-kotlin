# navigo-kotlin

Kotlin definition files for the Navigo JavaScript router.

https://github.com/krasimir/navigo

### Project info

The definition files are based on Navigo version 5.3.1.

### How to use

The releases of this project are available from bintray.
To use it in your project add the following code in your build.gradle.kts file.

    repositories {
        ...
        maven { url = uri("https://dl.bintray.com/rjaros/kotlin") }
    }

    dependencies {
        ...
        api("pl.treksoft:navigo-kotlin:$navigoKotlinVersion")
    }

Don't forget to include Navigo in your project.


    dependencies {
        ...
        implementation(npm("navigo"))
    }
