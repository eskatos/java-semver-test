plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    `java-library`
}


dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
}

testing {
    suites {
        "test"(JvmTestSuite::class) {
            useKotlinTest()
        }
    }
}
