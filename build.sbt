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

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
    <developers>
      <developer>
        <id>alexandre.delegue</id>
        <name>Alexandre Delègue</name>
        <url>https://github.com/larousso</url>
      </developer>
    </developers>
  )