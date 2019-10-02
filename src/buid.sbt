name := "sbt-example"
organization := "org.scalamacros"
version := "2.0.0"

scalaVersion in ThisBuild := "2.11.8"
run := run in Compile in todolist

lazy val mymacros = (project in file("macros")).settings(
 libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value,
scalaVersion := "2.12.4",
)

lazy val versions = new {
  val sri = "2018.2.2-RC"
}

lazy val todolist = ((project in file("scala")).enablePlugins(ScalaJSPlugin).settings(
scalaJSUseMainModuleInitializer := false,
scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule)),
name := "todolist",
scalaVersion := "2.12.4",
(fastOptJS in Compile) := {
  val result = (fastOptJS in Compile).value
  val inputFile = result.data
  val outputFile = new File("./scala/assets/generated/scalajs-output.js")
  IO.write(outputFile, "/* eslint-disable */\n" + IO.read(inputFile))
  result
},
(fullOptJS in Compile) := {
  val result = (fullOptJS in Compile).value
  val inputFile = result.data
  val outputFile = new File("./scala/assets/generated/scalajs-output.js")
  IO.write(outputFile, "/* eslint-disable */\n" + IO.read(inputFile))
  result
},
resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven"),
resolvers += Resolver.bintrayRepo("scalajs-plus", "maven"),
libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "core"                    % versions.sri,
  "scalajs-react-interface" %%% "mobile"                  % versions.sri,
  "scalajs-react-interface" %%% "universal"               % versions.sri,
  "scalajs-react-interface" %%% "vector-icons"            % versions.sri,
  "scalajs-react-interface" %%% "navigation"              % versions.sri
),
scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions"
)

)) dependsOn mymacros
