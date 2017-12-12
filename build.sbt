name := "sbt-ditaa"

organization := "com.adelegue"

version := "0.1"

description := "sbt plugin to build ditaa diagrams"

sbtPlugin := true

packageBin in Compile := (assembly in Compile).value

publishTo := {
  val localPublishRepo = "./repository"
  if (isSnapshot.value) {
    Some(Resolver.file("snapshots", new File(localPublishRepo + "/snapshots")))
  } else {
    Some(Resolver.file("releases", new File(localPublishRepo + "/releases")))
  }
}

publishMavenStyle := false

publishArtifact in Test := false
