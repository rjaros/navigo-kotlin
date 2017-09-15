# navigo-kotlin

Kotlin definition files for the Navigo JavaScript router.

https://github.com/krasimir/navigo

### Project info

The definition files are based on Navigo version 5.3.1.

### How to use

The releases of this project are available from bintray.
To use it in your project add the following code in your build.gradle file.

    repositories {
        ...
        maven { url = 'https://dl.bintray.com/rjaros/kotlin' }
    }

    dependencies {
        ...
        compile "pl.treksoft:navigo-kotlin:[version]"
    }

Use [kotlin-frontend-plugin](https://github.com/Kotlin/kotlin-frontend-plugin) to include Navigo to your project.

    kotlinFrontend {
        ...
        npm {
            ...
            dependency "navigo"
            ...
        }
        ...
    }
