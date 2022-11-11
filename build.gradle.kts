plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    `java-library`
}


dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    testImplementation(gradleApi())
    testImplementation("org.apache.maven:maven-artifact:3.8.6")
    testImplementation("com.github.zafarkhaja:java-semver:0.9.0")
    testImplementation("com.vdurmont:semver4j:3.1.0")
    testImplementation("io.github.g00fy2:versioncompare:1.5.0")
}

testing {
    suites {
        "test"(JvmTestSuite::class) {
            useKotlinTest()
        }
    }
}
