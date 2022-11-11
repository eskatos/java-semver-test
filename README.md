# Comparing version sorting on the JVM

This repository was created after Klaus Lehner's tweet (https://twitter.com/klu2/status/1590656427127091200) that compared the result of sorting version number strings. It compared Gradle's, Maven's and Java Semver's implementations and showed how different the results are. The goal of this repository is to add some other implementations and provide the code used for the comparisons.

Implementations used in this comparison:

- java.lang.module from Java >= 9
- Gradle
- Apache Maven
- Java Semver
- Semver4j
- VersionCompare

# Input

The unsorted list of versions used in this test is:

```
1.0.0
1.0.0-sp
1.0.0-SNAPSHOT
1.0.0-snapshot
1.0.0-release
1.0.0-alpha+2
1.0.0-final
1.0.0-rc.1.8+3bb4161
1.0.0-rc.1
1.0.0-alpha+1
1.0.0-ga
1.0.0-milestone.1.0+2cc3321
1.0.0-rc.1.9+4cc4322
```

## Outputs

```
java.lang.module.ModuleDescriptor.Version
  1.0.0-SNAPSHOT
  1.0.0-alpha+1
  1.0.0-alpha+2
  1.0.0-final
  1.0.0-ga
  1.0.0-milestone.1.0+2cc3321
  1.0.0-rc.1
  1.0.0-rc.1.8+3bb4161
  1.0.0-rc.1.9+4cc4322
  1.0.0-release
  1.0.0-snapshot
  1.0.0-sp
  1.0.0

org.gradle.api.internal.artifacts.ivyservice.ivyresolve.strategy.Version
  1.0.0-alpha+1
  1.0.0-alpha+2
  1.0.0-milestone.1.0+2cc3321
  1.0.0-rc.1
  1.0.0-rc.1.8+3bb4161
  1.0.0-rc.1.9+4cc4322
  1.0.0-SNAPSHOT
  1.0.0-snapshot
  1.0.0-final
  1.0.0-ga
  1.0.0-release
  1.0.0-sp
  1.0.0

org.apache.maven.artifact.versioning.ComparableVersion
  1.0.0-milestone.1.0+2cc3321
  1.0.0-rc.1
  1.0.0-rc.1.8+3bb4161
  1.0.0-rc.1.9+4cc4322
  1.0.0-SNAPSHOT
  1.0.0-snapshot
  1.0.0
  1.0.0-release
  1.0.0-final
  1.0.0-ga
  1.0.0-sp
  1.0.0-alpha+1
  1.0.0-alpha+2

com.vdurmont.semver4j.Semver
  1.0.0-alpha+2
  1.0.0-alpha+1
  1.0.0-final
  1.0.0-ga
  1.0.0-milestone.1.0+2cc3321
  1.0.0-rc.1
  1.0.0-rc.1.8+3bb4161
  1.0.0-rc.1.9+4cc4322
  1.0.0-release
  1.0.0-snapshot
  1.0.0-SNAPSHOT
  1.0.0-sp
  1.0.0
	
com.github.zafarkhaja.semver.Version
  1.0.0-SNAPSHOT
  1.0.0-alpha+2
  1.0.0-alpha+1
  1.0.0-final
  1.0.0-ga
  1.0.0-milestone.1.0+2cc3321
  1.0.0-rc.1
  1.0.0-rc.1.8+3bb4161
  1.0.0-rc.1.9+4cc4322
  1.0.0-release
  1.0.0-snapshot
  1.0.0-sp
  1.0.0

io.github.g00fy2.versioncompare.Version	
  1.0.0-SNAPSHOT
  1.0.0-snapshot
  1.0.0-alpha+1
  1.0.0-alpha+2
  1.0.0-rc.1.8+3bb4161
  1.0.0-rc.1
  1.0.0-rc.1.9+4cc4322
  1.0.0
  1.0.0-sp
  1.0.0-release
  1.0.0-final
  1.0.0-ga
  1.0.0-milestone.1.0+2cc3321
```
