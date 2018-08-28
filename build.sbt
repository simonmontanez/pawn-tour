scalaVersion := "2.12.6"
name := "pawn-tour"
organization := "truecaller.pawntour"
version := "1.0"

libraryDependencies ++= Seq(
  "org.typelevel"     %% "cats-core" % "1.1.0",
  "org.scalatest"     %% "scalatest" % "3.0.1",
  "com.typesafe.akka" %% "akka-http" % "10.1.4",
  "com.typesafe.akka" %% "akka-stream" % "2.5.12",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.4",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.4"
)

scalacOptions ++= Seq("-Xfatal-warnings",
                      "-Ywarn-dead-code",
                      "-Ywarn-numeric-widen",
                      "-Ywarn-value-discard",
                      "-Ywarn-unused-import")

coverageExcludedFiles := ".*Main.*"
coverageMinimum := 90.00
coverageFailOnMinimum := true

addCommandAlias("review", ";clean;coverage;test:scalafmt;test;coverageReport")
