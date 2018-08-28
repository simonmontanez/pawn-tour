
scalaVersion := "2.12.6"
name := "pawn-tour"
organization := "truecaller.pawntour"
version := "1.0"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.1.0",
  "org.scalatest" %% "scalatest" % "3.0.1"
)

coverageMinimum := 90.00
//coverageFailOnMinimum := true

addCommandAlias("review", ";clean;coverage;test:scalafmt;test;coverageReport")
