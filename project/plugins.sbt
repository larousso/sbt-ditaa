resolvers += Resolver.jcenterRepo

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.12")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC11")
addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.2")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.7.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.9.3")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.7")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.3")