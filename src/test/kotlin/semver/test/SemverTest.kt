package semver.test

import com.github.zafarkhaja.semver.Version
import com.vdurmont.semver4j.Semver
import org.apache.maven.artifact.versioning.ComparableVersion
import org.gradle.api.internal.artifacts.ivyservice.ivyresolve.VersionInfo
import org.gradle.api.internal.artifacts.ivyservice.ivyresolve.strategy.DefaultVersionComparator
import org.gradle.api.internal.artifacts.ivyservice.ivyresolve.strategy.VersionParser
import kotlin.test.Test

class SemverTest {

    private
    val versions = listOf(
        "1.0.0",
        "1.0.0-sp",
        "1.0.0-SNAPSHOT",
        "1.0.0-snapshot",
        "1.0.0-release",
        "1.0.0-alpha+2",
        "1.0.0-final",
        "1.0.0-rc.1.8+3bb4161",
        "1.0.0-rc.1",
        "1.0.0-alpha+1",
        "1.0.0-ga",
        "1.0.0-milestone.1.0+2cc3321",
        "1.0.0-rc.1.9+4cc4322",
    )

    @Test
    fun sortVersions() {
        sortVersionsWithJavaLangModule()
        sortVersionsWithGradle()
        sortVersionsWithMaven()
        sortVersionsWithJavaSemver()
        sortVersionsWithSemver4j()
        sortVersionsWithVersionCompare()
    }

    @Test
    fun sortVersionsWithJavaSemver() {
        printSortedVersions<Semver>(
            versions.map { Semver(it) }.sorted()
        )
    }

    @Test
    fun sortVersionsWithSemver4j() {
        printSortedVersions<Version>(
            versions.map { Version.valueOf(it) }.sorted()
        )
    }

    @Test
    fun sortVersionsWithMaven() {
        printSortedVersions<ComparableVersion>(
            versions.map { ComparableVersion(it) }.sorted()
        )
    }

    @Test
    fun sortVersionsWithGradle() {
        printSortedVersions<org.gradle.api.internal.artifacts.ivyservice.ivyresolve.strategy.Version>(
            versions.map { VersionInfo(VersionParser().transform(it)) }
                .sortedWith(DefaultVersionComparator())
                .map { it.version }
        )
    }

    @Test
    fun sortVersionsWithJavaLangModule() {
        printSortedVersions<java.lang.module.ModuleDescriptor.Version>(
            versions.map { java.lang.module.ModuleDescriptor.Version.parse(it) }.sorted()
        )
    }

    @Test
    fun sortVersionsWithVersionCompare() {
        printSortedVersions<io.github.g00fy2.versioncompare.Version>(
            versions.map { io.github.g00fy2.versioncompare.Version(it) }.sorted()
        )
    }

    private
    inline fun <reified T : Any> printSortedVersions(sortedVersions: List<Any>) {
        println(T::class.qualifiedName)
        println(sortedVersions.joinToString(prefix = "  ", separator = "${System.lineSeparator()}  "))
        println()
    }
}
