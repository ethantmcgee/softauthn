import com.vanniktech.maven.publish.SonatypeHost

plugins {
    `java-library`
    `maven-publish`
    signing
    id("com.vanniktech.maven.publish") version "0.31.0-rc2"
}

group = "dev.ethantmcgee"
version = "0.1.4"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    implementation("com.augustcellars.cose:cose-java:1.1.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0-rc2")
    api("com.yubico:webauthn-server-core:2.6.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates("dev.ethantmcgee", "softauthn", "0.1.4")

    pom {
        name.set("softauthn")
        description.set("softauthn provides an implementation of the WebAuthn API and a software authenticator " +
                "in Java, using the java-webauthn-server library for data models. It can be used to test " +
                "WebAuthn backends.")
        inceptionYear.set("2022")
        url.set("https://github.com/ethantmcgee/softauthn")
        licenses {
            license {
                name.set("MIT")
                url.set("https://mit-license.org")
                distribution.set("https://mit-license.org")
            }
        }
        developers {
            developer {
                id.set("ethantmcgee")
                name.set("Ethan McGee")
                url.set("https://github.com/ethantmcgee/")
            }
        }
        scm {
            url.set("https://github.com/ethantmcgee/softauthn")
            connection.set("scm:git:git://github.com/ethantmcgee/softauthn.git")
            developerConnection.set("scm:git:ssh://git@github.com/ethantmcgee/softauthn.git")
        }
    }
}
