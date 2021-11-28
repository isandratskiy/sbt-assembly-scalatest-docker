name := "sbt-assembly-scalatest-docker"

version := "1.0"

scalaVersion := "2.13.6"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sbt-assembly-scalatest-docker",
    libraryDependencies ++= Seq(
      "org.scalacheck" %% "scalacheck" % "1.15.4",
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3"
    ).map(_ % Test),
    assemblySettings
  )

lazy val assemblySettings = Seq(
  assembly / mainClass := Some("org.scalatest.tools.Runner"),
  assembly / fullClasspath := (Test / fullClasspath).value,
  assembly / dependencyClasspath := (Test / dependencyClasspath).value,
  assembly / assemblyOutputPath := file(s"target/build/${name.value}-${version.value}.jar"),
  assembly / assemblyMergeStrategy := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case "application.conf"            => MergeStrategy.concat
    case x =>
      val oldStrategy = (assembly / assemblyMergeStrategy).value
      oldStrategy(x)
  }
)