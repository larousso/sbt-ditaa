import sbtrelease.ReleaseStateTransformations._

name := "sbt-ditaa"

organization := "com.adelegue"

description := "sbt plugin to build ditaa diagrams"

sbtPlugin := true

packageBin in Compile := (assembly in Compile).value

resolvers += Resolver.bintrayRepo("larousso", "maven")

lazy val githubRepo = "larousso/sbt-ditaa"

releaseCrossBuild := false

homepage := Some(url(s"https://github.com/$githubRepo"))
startYear := Some(2017)
licenses := Seq(("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")))
scmInfo := Some(
  ScmInfo(
    url(s"https://github.com/$githubRepo"),
    s"scm:git:https://github.com/$githubRepo.git",
    Some(s"scm:git:git@github.com:$githubRepo.git")
  )
)
developers := List(
  Developer("alexandre.delegue", "Alexandre Delègue", "", url(s"https://github.com/larousso"))
)
publishMavenStyle := true

publishArtifact in Test := false

bintrayVcsUrl := Some(s"scm:git:git@github.com:$githubRepo.git")

bintrayCredentialsFile := file(".credentials")

pomIncludeRepository := { _ => false }

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges)