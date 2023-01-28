ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "gwen-t.scala",
    idePackagePrefix := Some("cl.uchile.dcc.gwent")
  )
libraryDependencies += "com.beautiful-scala" %% "scalastyle" % "1.5.1"
libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.14.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.15" % Test
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-16" % "3.2.14.0" % Test