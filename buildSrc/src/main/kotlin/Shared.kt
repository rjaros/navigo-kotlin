import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPom
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.gradle.plugins.signing.SigningExtension

fun MavenPom.defaultPom() {
    name.set("navigo-kotlin")
    description.set("Kotlin definition files for the Navigo JavaScript router.")
    url.set("https://github.com/rjaros/navigo-kotlin")
    licenses {
        license {
            name.set("MIT")
            url.set("https://opensource.org/licenses/MIT")
        }
    }
    developers {
        developer {
            id.set("rjaros")
            name.set("Robert Jaros")
            organization.set("Treksoft")
            organizationUrl.set("http://www.treksoft.pl")
        }
    }
    scm {
        url.set("https://github.com/rjaros/navigo-kotlin.git")
        connection.set("scm:git:git://github.com/rjaros/navigo-kotlin.git")
        developerConnection.set("scm:git:git://github.com/rjaros/navigo-kotlin.git")
    }
}

fun Project.setupSigning() {
    extensions.getByType<SigningExtension>().run {
        sign(extensions.getByType<PublishingExtension>().publications)
    }
}

fun Project.setupPublication() {
    plugins.apply("maven-publish")

    extensions.getByType<PublishingExtension>().run {
        publications.withType<MavenPublication>().all {
            pom {
                defaultPom()
            }
        }

        repositories {
            maven {
                url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = findProperty("ossrhUsername")?.toString()
                    password = findProperty("ossrhPassword")?.toString()
                }
            }
        }
    }
}
