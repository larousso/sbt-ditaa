import sbtrelease.ReleaseStateTransformations._


lazy val root = (project in file("."))
  .enablePlugins(BuildInfoPlugin, GitVersioning, GitBranchPrompt)
  .settings(
    name := "sbt-ditaa",
    organization := "com.adelegue",
    description := "sbt plugin to build ditaa diagrams",
    resolvers += Resolver.bintrayRepo("larousso", "maven"),
    sbtPlugin := true,
    packageBin in Compile := (assembly in Compile).value,
  )
  .settings(publishSettings:_*)

lazy val githubRepo = "larousso/sbt-ditaa"

lazy val publishSettings =
  Seq(
    homepage := Some(url(s"https://github.com/$githubRepo")),
    startYear := Some(2017),
    licenses := Seq(("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))),
    scmInfo := Some(
      ScmInfo(
        url(s"https://github.com/$githubRepo"),
        s"scm:git:https://github.com/$githubRepo.git",
        Some(s"scm:git:git@github.com:$githubRepo.git")
      )
    ),
    developers := List(
      Developer("alexandre.delegue", "Alexandre Delègue", "", url(s"https://github.com/larousso"))
    ),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    bintrayVcsUrl := Some(s"scm:git:git@github.com:$githubRepo.git"),
    bintrayCredentialsFile := file(".credentials"),
    pomIncludeRepository := { _ => false }
  )

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